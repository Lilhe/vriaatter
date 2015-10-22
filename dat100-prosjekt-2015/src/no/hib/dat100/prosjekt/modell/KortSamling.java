package no.hib.dat100.prosjekt.modell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

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

	public Kort[] samling;
	public int antall;
	
	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		samling = new Kort[MAKS_KORT];
		antall = 0;
	}

	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
		if (antall == 0) {
			return true;
		}
		return false;
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
		return samling;
	}

	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		return antall;
	}

	/**
	 * Legger alle korta (hele kortstokken) til samlnga. Korta vil vÊre sortert
	 * slik at de normalt mÂ stokkes f¯r bruk.
	 */
	public void leggTilAlle() {
		for (int i = 0; i < MAKS_KORT_FARGE; i++) {
			samling[antall] = new Kort(Kortfarge.Hjerter, i);
			antall++;
			samling[antall] = new Kort(Kortfarge.Klover, i);
			antall++;
			samling[antall] = new Kort(Kortfarge.Ruter, i);
			antall++;
			samling[antall] = new Kort(Kortfarge.Spar, i);
			antall++;
		}
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		Arrays.fill(samling, null);
		antall = 0;
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		samling[antall] = kort;
		antall++;
	}

	/**
	 * Ser pÂ siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet.
	 */
	public Kort seSiste() {
		return samling[antall-1];
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		antall--;
		Kort temp = samling[antall];
		samling[antall] = null;
		return temp;
	}

	/**
	 * Unders¯ker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		ArrayList<Kort> temp = toArrayList();
		return temp.contains(kort);
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
		ArrayList<Kort> temp = toArrayList();
		temp.remove(kort);
		samling = temp.toArray(samling);
	}

	/**
	 * Stokkar en kortsamling. Etter metoden er utf¯rt har alle kort samme
	 * sannsynligheit for Â vÊre pÂ ein spesiell plass.
	 * 
	 */
	public void stokk() {
		ArrayList<Kort> temp = toArrayList();
		Collections.shuffle(temp, new Random(System.nanoTime()));
		samling = temp.toArray(samling);
	}

	/**
	 * Gir kortene som en ArrayList.
	 * 
	 * @return samlinga av kort som en ArrayList. Korta vil ha samme rekkef¯lge
	 *         som i kortsamlinga.
	 */
	public ArrayList<Kort> toArrayList() {
		ArrayList<Kort> temp = new ArrayList<Kort>();
		for (int i = 0; i < antall; i++) {
			temp.add(samling[i]);
		}
		return temp;
	}
}
