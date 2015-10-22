package no.hib.dat100.prosjekt.modell;

import java.util.ArrayList;

/**
 * Struktur for Â lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * konstanter i klassen som angir antall kort i hver av de 4 fargene. NÂr
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det vÊre praktisk Â ha denne mindre.
 * 
 */
public abstract class KortSamling {

	public static final int MAKS_KORT_FARGE = 3;
	private final int MAKS_KORT = 4 * MAKS_KORT_FARGE;

	// legg til objektvariable her

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		throw new RuntimeException("kortsamling ikke implementert");
	}

	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
		throw new RuntimeException("erTom ikke implementert");
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke vÊre
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan fÂ
	 * tilgang til antallet ved Â bruke metoden getAntallKort(). Metoden er
	 * f¯rst og fremst ment Â brukes i eventuelle subklasser. Om man trenger
	 * kortene utenfor arvehierarkiet, anbefales metoden toArrayList().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {
		throw new RuntimeException("getSamling ikke implementert");
	}

	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		throw new RuntimeException("getAntalKort ikke implementert");
	}

	/**
	 * Legger alle korta (hele kortstokken) til samlnga. Korta vil vÊre sortert
	 * slik at de normalt mÂ stokkes f¯r bruk.
	 */
	public void leggTilAlle() {
		throw new RuntimeException("leggTilAlle ikke implementert");
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		throw new RuntimeException("fjernAlle ikke implementert");
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		throw new RuntimeException("leggTil ikke implementert");
	}

	/**
	 * Ser pÂ siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet.
	 */
	public Kort seSiste() {
		throw new RuntimeException("seSiste ikke implementert");
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		
		throw new RuntimeException("taSiste ikke implementert");
	}

	/**
	 * Unders¯ker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {

		throw new RuntimeException("har ikke implementert");
	}

	/**
	 * Fjernar et kort frÂ samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting.
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 */
	public void fjern(Kort kort) {
		throw new RuntimeException("fjern ikke implementert");
	}

	/**
	 * Stokkar en kortsamling. Etter metoden er utf¯rt har alle kort samme
	 * sannsynligheit for Â vÊre pÂ ein spesiell plass.
	 * 
	 */
	public void stokk() {
		throw new RuntimeException("stokk ikke implementert");
	}

	/**
	 * Gir kortene som en ArrayList.
	 * 
	 * @return samlinga av kort som en ArrayList. Korta vil ha samme rekkef¯lge
	 *         som i kortsamlinga.
	 */
	public ArrayList<Kort> toArrayList() {
		
		throw new RuntimeException("toArrayList ikke implementert");
	}
}
