package no.hib.dat100.prosjekt.kontroll;

import java.util.ArrayList;
import java.util.Random;

import no.hib.dat100.prosjekt.modell.Kort;

public class RandomSpiller extends Spiller {

	public RandomSpiller(Spillere spiller) {
		super(spiller);
	}

	@Override
	public Handling nesteHandling(Kort topp) {
		ArrayList<Kort> h = getHand().toArrayList();
		ArrayList<Kort> lovlige = new ArrayList<Kort>();
		ArrayList<Kort> attere = new ArrayList<Kort>();

		for (Kort k : h) {
			if (Regler.kanLeggeNed(k, topp)) {
				if (Regler.atter(k)) {
					attere.add(k);
				} else {
					lovlige.add(k);
				}
			}
		}

		Kort spill = null;
		ArrayList<Kort> spillFra = null;

		if (!lovlige.isEmpty()) {
			spillFra = lovlige;
		} else if (!attere.isEmpty()) {
			spillFra = attere;
		}

		Handling tur = null;
		if (spillFra != null) {
			Random r = new Random();
			int p = r.nextInt(spillFra.size());
			spill = spillFra.get(p);
			tur = new Handling(HandlingsType.LEGGNED, spill);
			setAntallTrekk(0);
		} else if (getAntallTrekk() < Regler.maksTrekk()) {
			tur = new Handling(HandlingsType.TREKK, null);
		} else {
			tur = new Handling(HandlingsType.FORBI, null);
			setAntallTrekk(0);
		}

		return tur;
	}

}
