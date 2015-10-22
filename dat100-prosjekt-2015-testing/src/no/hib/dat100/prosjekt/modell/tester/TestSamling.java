package no.hib.dat100.prosjekt.modell.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import no.hib.dat100.prosjekt.modell.Kort;
import no.hib.dat100.prosjekt.modell.Kortfarge;

public class TestSamling {

	@Rule
	public TestRule globalTimeout = new Timeout(30000); 

	@Test
	public void TestConstructor() {

		TKortSamling samling = new TKortSamling();

		assertTrue(samling.erTom());
		assertEquals(samling.getAntalKort(), 0);
	}

	@Test
	public void TestleggTil() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		assertEquals(samling.getAntalKort(), 3);
		assertTrue(samling.har(kort1));
		assertTrue(samling.har(kort2));
		assertTrue(samling.har(kort3));
		assertFalse(samling.har(null));
	}

	@Test
	public void TestseSiste() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		assertEquals(samling.seSiste(), kort3);
		assertEquals(samling.getAntalKort(), 3);
	}

	@Test
	public void TesttaSiste() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		assertEquals(samling.taSiste(), kort3);
		assertEquals(samling.getAntalKort(), 2);
	}

	@Test
	public void Testfjern() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		samling.fjern(kort2);

		assertTrue(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertTrue(samling.har(kort3));
		assertFalse(samling.har(null));
	}

	@Test
	public void TestfjernAlle() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		samling.fjernAlle();

		assertFalse(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertFalse(samling.har(kort3));
		assertTrue(samling.erTom());
	}

	@Test
	public void Teststokk() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		assertEquals(samling.getAntalKort(), 3);
		assertTrue(samling.har(kort1));
		assertTrue(samling.har(kort2));
		assertTrue(samling.har(kort3));
		assertFalse(samling.har(null));
	}

	@Test
	public void TesttoArrayList() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		ArrayList<Kort> kortarray = samling.toArrayList();

		assertEquals(kortarray.size(), 3);
		assertEquals(kortarray.get(0), kort1);
		assertEquals(kortarray.get(1), kort2);
		assertEquals(kortarray.get(2), kort3);

	}
}
