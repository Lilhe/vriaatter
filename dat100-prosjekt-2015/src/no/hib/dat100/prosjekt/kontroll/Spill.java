package no.hib.dat100.prosjekt.kontroll;

import java.util.ArrayList;

import no.hib.dat100.prosjekt.modell.Bunke;
import no.hib.dat100.prosjekt.modell.Kort;

/**
 * Klassen har objektvariaber som er referanser til de spillerne, nord og syd
 * (type ISpiller). Den har ogsÂ en bunke man deler/trekker fra og en bunke man
 * spiller til.
 * 
 */
public class Spill {

	// legg til objektvariable her
	private ISpiller nord;
	private ISpiller syd;
	
	private Bunke tilBunke;
	private Bunke fraBunke;
	
	
	/**
	 * Gir referanse/peker til syd.
	 * 
	 * @return referanse/peker til syd.
	 */
	public ISpiller getSyd() {
		return syd;
	}

	/**
	 * Gir referanse/peker til nord.
	 * 
	 * @return referanse/peker til nord.
	 */
	public ISpiller getNord() {
		return nord;
	}

	/**
	 * Gir peker/referanse til til-bunken.
	 * 
	 * @return referanse/peker til til-bunken.
	 */
	public Bunke getBunkeTil() {
		return tilBunke;
	}

	public Bunke getBunkeFra() {
		return fraBunke;
	}

	/**
	 * Metoden oppretter to spillere, nord og syd. Det opprettes to bunker, fra
	 * og til. Alle kortene legges til fra. Bunken fra stokkes. Deretter deles
	 * det ut kort fra fra-bunken til nord og syd i henhold til regler. Til
	 * slutt tas ¯verste kortet fra fra-bunken og legges til til-bunken.
	 * 
	 * Nord har type RandomSpiller (som er forhÂndefinert). Syd vil vÊre spiller
	 * av en klasse laget av gruppen.
	 */
	public void start() {
		nord = new RandomSpiller(Spillere.NORD);
		syd = new FirstFitSpiller(Spillere.SYD);
		
		tilBunke = new Bunke();
		fraBunke = new Bunke();
		
		fraBunke.leggTilAlle();
		fraBunke.stokk();
		
		delutKort();
		
		vendOverste();
		
		nord.setAntallTrekk(0);
		syd.setAntallTrekk(0);
	}

	/**
	 * Deler ut kort til nord og syd.
	 * 
	 */
	private void delutKort() {
		while (syd.getAntallKort() < Regler.antallKortVedStart()) {
		nord.trekker(fraBunke.trekk());
		syd.trekker(fraBunke.trekk());
		}
	}

	/**
	 * Tar ¯verste kortet fra fra-bunken og legger dettte til til-bunken (med
	 * billedsiden opp, men det trenger ikke gruppen tenke pÂ).
	 */
	private void vendOverste() {
		tilBunke.leggTil(fraBunke.trekk());
	}

	/**
	 * NÂr fra-bunken blir tom, tar man vare pÂ kortet pÂ toppen av til-bunken.
	 * Deretter legges alle den andre kortene i til-bunken over i fra-bunken.
	 * Denne stokkes og kortet som man har tatt vare pÂ legges tilbake i
	 * til-bunken. Det vil nÂr vÊre det eneste kortet i til-bunken.
	 */
	public void snuTilBunken() {
		for (int i = 0; i < tilBunke.getAntalKort(); i++) {
			fraBunke.leggTil(tilBunke.getSamling()[i]);
		}
		tilBunke.fjernAlle();
		tilBunke.leggTil(fraBunke.taSiste());
		fraBunke.stokk();
	}

	/**
	 * Trekker et kort fra fra-bunken til spilleren gitt som parameter. Om
	 * fra-bunken er tom, mÂ man "snu" til-bunken. Se info om metoden
	 * snuTilBunken().
	 * 
	 * @param spiller
	 *            spilleren som trekker.
	 * 
	 * @return kortet som trekkes.
	 */
	public Kort trekkFraBunke(ISpiller spiller) {
		if (fraBunke.erTom()) {
			snuTilBunken();
		}
		spiller.trekker(fraBunke.seSiste());
		return fraBunke.taSiste();
	}

	/**
	 * Sjekker om til-bunken er tom.
	 * 
	 * @return true om til-bunken er tom, false ellers.
	 */
	public boolean bunketilTom() {
		return tilBunke.erTom();
	}

	/**
	 * Sjekker om fra-bunken er tom.
	 * 
	 * @return true om fra-bunken er tom, false ellers.
	 */
	public boolean bunkefraTom() {
		return fraBunke.erTom();
	}

	/**
	 * Gir antall kort nord har pÂ hÂnden.
	 * 
	 * @return antall kort nord har pÂ hÂnden.
	 */
	public int antallNord() {
		return nord.getAntallKort();
	}

	/**
	 * Gir antall kort i fra-bunken.
	 * 
	 * @return antall kort i fra-bunken.
	 */
	public int antallBunkeFra() {
		return fraBunke.getAntalKort();
	}

	/**
	 * Gir antall kort i til-bunken.
	 * 
	 * @return antall kort i til-bunken.
	 */
	public int antallBunkeTil() {
		return tilBunke.getAntalKort();
	}

	/**
	 * Metode som leser ¯verste kortet i til-bunken. Kortet vil fremdeles vÊre
	 * ¯verst i til-bunken etter at metoden er utf¯rt.
	 * 
	 * @return ¯verste kortet i til-bunken.
	 */
	public Kort seOverste() {
		return tilBunke.seSiste();
	}

	/**
	 * Gir syds hand som en ArrayList av Kort.
	 * 
	 * @return syds hand som en ArrayList av Kort.
	 */
	public ArrayList<Kort> getSydHand() {
		return syd.getHand().toArrayList();
	}

	/**
	 * Gir neste handling for en spiller (spilt et kort, trekker et kort, forbi)
	 * 
	 * @param spiller
	 *            spiller som handle.
	 * 
	 * @return handlingen som blir utf¯rt.
	 */
	public Handling nesteHandling(ISpiller spiller) {
		return spiller.nesteHandling(tilBunke.seSiste());
	}

	/**
	 * Metoden spiller et kort. Den sjekker at spiller har kortet. Dersom det er
	 * tilfelle, fjernes kortet fra spilleren og legges til til-bunken. Metoden
	 * nulltiller ogsÂ antall ganger spilleren har trukket kort.
	 * 
	 * @param spiller
	 *            den som spiller.
	 * @param kort
	 *            kort som spilles.
	 * 
	 * @return true dersom spilleren har kortet, false ellers.
	 */
	public boolean leggnedKort(ISpiller spiller, Kort kort) {
		if (spiller.getHand().har(kort)) {
			spiller.fjernKort(kort);
			tilBunke.leggTil(kort);
			spiller.setAntallTrekk(0);
			return true;
		}
		return false;
	}

	/**
	 * Metode for Â si forbi. MÂ nullstille antall ganger spilleren har trukket
	 * kort.
	 * 
	 * @param spiller
	 *            spilleren som er i tur.
	 */
	public void forbiSpiller(ISpiller spiller) {
		utforHandling(spiller, new Handling(HandlingsType.FORBI, null));
		spiller.setAntallTrekk(0);
	}

	/**
	 * Metode for Â utf¯re en handling (trekke, spille, forbi). Dersom hanling
	 * er kort, blir kortet ogsÂ spilt.
	 * 
	 * @param spiller
	 *            spiller som utf¯rer handlingen.
	 * @param handling
	 *            handling som utf¯res.
	 * 
	 * @return kort som trekkes, kort som spilles eller null ved forbi.
	 */
	public Kort utforHandling(ISpiller spiller, Handling handling) {
		if (handling.getType() == HandlingsType.LEGGNED) {
			leggnedKort(spiller, handling.getKort());
			return handling.getKort();
		} else if (handling.getType() == HandlingsType.TREKK) {
			spiller.trekker(fraBunke.taSiste());
			spiller.setAntallTrekk(spiller.getAntallTrekk()+1);
			return handling.getKort();
		}
		return null;
	}

	/**
	 * Siller et kort fra syd.
	 * 
	 * @param kort
	 *            kort som spilles.
	 * 
	 * @return true dersom kortet er lovlig Â spille, false ellers.
	 */
	public boolean nedkortSyd(Kort kort) {
		return leggnedKort(syd, kort);
	}

	/**
	 * ForeslÂr hva syd skal spille.
	 * 
	 * @return kort som blir foreslÂtt.
	 */
	public Kort foreslaaKortSyd() {
		for (int i = 0; i < syd.getAntallKort(); i++) {
			if (syd.getHand().getSamling()[i].getVerdi() == 8) {
				return syd.getHand().getSamling()[i];
			} else if (seOverste().sammeFarge(syd.getHand().getSamling()[i])) {
				return syd.getHand().getSamling()[i];
			} else if (seOverste().sammeVerdi(syd.getHand().getSamling()[i])) {
				return syd.getHand().getSamling()[i];
			}
		}
		return null;
	}
}