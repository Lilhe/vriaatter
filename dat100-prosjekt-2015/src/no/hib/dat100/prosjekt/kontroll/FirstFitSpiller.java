package no.hib.dat100.prosjekt.kontroll;

import java.util.ArrayList;

import no.hib.dat100.prosjekt.modell.Kort;

/**
 * Klasse som for Â representere en vriÂtter spiller. Strategien er Â lete
 * gjennom kortene man har pÂ hand og spille det f¯rste som er lovlig.
 *
 */
public class FirstFitSpiller extends Spiller {

	/**
	 * Konstrukt¯r.
	 * 
	 * @param spiller
	 *            posisjon for spilleren (nord eller syd).
	 */
	public FirstFitSpiller(Spillere spiller) {
		super(spiller);
	}

	/**
	 * Metode for Â implementere strategi. Strategien er Â spille det f¯rste
	 * kortet som er lovlig (ogsÂ en Âtter selv om man har andre kort som ogsÂ
	 * kan spilles). Dersom man ikke har lovlige kort Â spille, trekker man om
	 * man ikke allerede har trukket maks antall ganger. I sÂ fall sier man
	 * forbi.
	 * 
	 * @param topp
	 *            kort som ligg ¯verst pÂ til-bunken.
	 */
	@Override
	public Handling nesteHandling(Kort topp) {

		throw new RuntimeException("nesteHandling ikke implementert");
	}
}
