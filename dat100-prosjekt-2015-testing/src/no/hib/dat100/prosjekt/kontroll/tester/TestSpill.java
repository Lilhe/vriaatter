package no.hib.dat100.prosjekt.kontroll.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import no.hib.dat100.prosjekt.kontroll.ISpiller;
import no.hib.dat100.prosjekt.kontroll.Regler;
import no.hib.dat100.prosjekt.kontroll.Spill;
import no.hib.dat100.prosjekt.kontroll.Spillere;
import no.hib.dat100.prosjekt.modell.Bunke;
import no.hib.dat100.prosjekt.modell.Kort;
import no.hib.dat100.prosjekt.modell.KortSamling;
import no.hib.dat100.prosjekt.modell.Kortfarge;

public class TestSpill {

	@Test
	public void Teststart() {
		Spill spill = new Spill();

		spill.start();

		ISpiller syd = spill.getSyd();
		ISpiller nord = spill.getNord();

		Bunke bunkeTil = spill.getBunkeTil();
		Bunke bunkeFra = spill.getBunkeFra();

		assertEquals(syd.hvem(), Spillere.SYD);
		assertEquals(nord.hvem(), Spillere.NORD);

		assertEquals(syd.getAntallKort(), Regler.antallKortVedStart());
		assertEquals(nord.getAntallKort(), Regler.antallKortVedStart());

		assertEquals(bunkeTil.getAntalKort(), 1);
		assertEquals(bunkeFra.getAntalKort(), KortSamling.MAKS_KORT_FARGE * 4 - (Regler.antallKortVedStart() * 2) - 1);

	}

	@Test
	public void TestsnuBunken() {
		Spill spill = new Spill();

		spill.start();

		Bunke bunkeTil = spill.getBunkeTil();
		Bunke bunkeFra = spill.getBunkeFra();

		int bunkefraantall = bunkeFra.getAntalKort();

		while (!bunkeFra.erTom()) {
			bunkeTil.leggTil(bunkeFra.trekk());
		}

		Kort overst = bunkeTil.topp();

		spill.snuTilBunken();

		bunkeTil = spill.getBunkeTil();
		bunkeFra = spill.getBunkeFra();

		assertEquals(bunkeTil.getAntalKort(), 1);
		assertEquals(bunkeTil.topp(), overst);
		assertEquals(bunkeFra.getAntalKort(), bunkefraantall);

	}

	@Test
	public void TestHenteMetoder() {
		Spill spill = new Spill();

		spill.start();
		
		assertFalse(spill.bunketilTom());
		assertFalse(spill.bunkefraTom());
		assertEquals(spill.antallNord(),Regler.antallKortVedStart());
		assertEquals(spill.antallBunkeFra(),KortSamling.MAKS_KORT_FARGE * 4 - (Regler.antallKortVedStart() * 2) - 1);
		assertEquals(spill.antallBunkeTil(), 1);
	}
	
	@Test
	public void TesttrekkFraBunke() {
		Spill spill = new Spill();

		spill.start();
		
		ISpiller spiller = spill.getSyd();
		Bunke bunkefra = spill.getBunkeFra();
		
		int antallspiller = spiller.getAntallKort();
		int antallbunke = bunkefra.getAntalKort();
		
		spill.trekkFraBunke(spiller);
		
		assertEquals(spiller.getAntallKort(),antallspiller+1);
		assertEquals(spiller.getAntallTrekk(),1);
		assertEquals(bunkefra.getAntalKort(),antallbunke-1);
	}
	
	@Test
	public void TestleggnedKort() {
		
		Spill spill = new Spill();

		spill.start();
		
		ISpiller spiller = spill.getSyd();
		Kort kort = new Kort(Kortfarge.Hjerter,1);
		
		Bunke bunketil = spill.getBunkeTil();
		int antallbunketil = bunketil.getAntalKort();
		
		spiller.leggTilKort(kort);
		int antallkortsspiller = spiller.getAntallKort();
		spill.leggnedKort(spiller,kort);
		
		assertEquals(bunketil.getAntalKort(),antallbunketil+1);
		assertEquals(spiller.getAntallKort(),antallkortsspiller-1);
		assertEquals(bunketil.topp(),kort);
	}
	
	@Test
	public void TestforbiSpiller() {
		
		Spill spill = new Spill();

		spill.start();
		
		ISpiller spiller = spill.getSyd();
		
		spill.trekkFraBunke(spiller);
		spill.forbiSpiller(spiller);
		
		assertEquals(spiller.getAntallTrekk(),0);
	}
}
