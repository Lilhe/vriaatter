package no.hib.dat100.prosjekt.kontroll;

import no.hib.dat100.prosjekt.modell.Hand;
import no.hib.dat100.prosjekt.modell.Kort;

/**
 * Abstrakt klasse som implementerer alle metodene i kontrakten ISpiller,
 * bortsett fra nesteHandling(). Dette er grunnen til at klassen er abstrakt.
 * For Â lage "virkelige" spillere, mÂ vi arve fra denne klassen og implmentere
 * nesteHandling (fra ISpiller).
 * 
 * Klassen har objektvariablene hand (Hand), antalltrekk (heltall) og spiller
 * (Spillere). Den har to konstrukt¯rer. Se beskrivelse av disse.
 * 
 */
public abstract class Spiller implements ISpiller {

	// legg til objektvariable her

	/**
	 * Standard konstrukt¯r som oppretter en Spiller med en hÂnd uten kort,
	 * antalltrekk som 0 og setter spiller til Spillere.INGEN.
	 */
	public Spiller() {
		throw new RuntimeException("Spiller kontruktør ikke implementert");
	}

	/**
	 * Konstrukt¯r der vi kan sette hvilken spiller det er (NORD, SYD eller
	 * INGEN).
	 * 
	 * @param spiller
	 *            hvilken spiller det er.
	 */
	public Spiller(Spillere spiller) {
		throw new RuntimeException("Spiller konstruktør ikke implementert");
	}

	@Override
	public int getAntallKort() {
		throw new RuntimeException("getAntallKort ikke implementert");
	}

	@Override
	public Hand getHand() {
		throw new RuntimeException("getHand ikke implementert");
	}

	public int getAntallTrekk() {
		throw new RuntimeException("getAntallTrekk ikke implementert");
	}

	public Spillere hvem() {
		throw new RuntimeException("hvem ikke implementert");
	}

	public void setAntallTrekk(int t) {
		throw new RuntimeException("setAntallTrekk ikke implementert");
	}

	@Override
	public boolean erFerdig() {
		throw new RuntimeException("erFerdig ikke implementert");
	}

	@Override
	public void leggTilKort(Kort kort) {
		throw new RuntimeException("leggTilkort ikke implementert");
	}

	@Override
	public void fjernKort(Kort kort) {
		throw new RuntimeException("fjernKort ikke implementert");
	}

	@Override
	public void fjernAlleKort() {
		throw new RuntimeException("fjernAlleKort ikke implementert");
	}

	@Override
	public void trekker(Kort kort) {
		throw new RuntimeException("trekker ikke implementert");
	}
}
