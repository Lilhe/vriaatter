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
	
	public Spillere spiller;
	public Hand hand;
	public int antallTrekk;
	/**
	 * Standard konstrukt¯r som oppretter en Spiller med en hÂnd uten kort,
	 * antalltrekk som 0 og setter spiller til Spillere.INGEN.
	 */
	public Spiller() {
		spiller = Spillere.INGEN;
		hand = new Hand();
		antallTrekk = 0;
	}

	/**
	 * Konstrukt¯r der vi kan sette hvilken spiller det er (NORD, SYD eller
	 * INGEN).
	 * 
	 * @param spiller
	 *            hvilken spiller det er.
	 */
	public Spiller(Spillere spiller) {
		this.spiller = spiller;
	}

	@Override
	public int getAntallKort() {
		return hand.getAntalKort();
	}

	@Override
	public Hand getHand() {
		return hand;
	}

	public int getAntallTrekk() {
		return antallTrekk;
	}

	public Spillere hvem() {
		return spiller;
	}

	public void setAntallTrekk(int t) {
		antallTrekk = t;
	}

	@Override
	public boolean erFerdig() {
		return hand.getAntalKort() == 0;
	}

	@Override
	public void leggTilKort(Kort kort) {
		hand.leggTil(kort);
	}

	@Override
	public void fjernKort(Kort kort) {
		hand.fjern(kort);
	}

	@Override
	public void fjernAlleKort() {
		hand.fjernAlle();
	}

	@Override
	public void trekker(Kort kort) {
		leggTilKort(kort);
		antallTrekk++;
	}
}
