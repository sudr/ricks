package org.sudr.hfooad.ricks;

import java.util.Collection;

import org.sudr.hfooad.ricks.GuitarSpec.Builder;
import org.sudr.hfooad.ricks.GuitarSpec.Type;
import org.sudr.hfooad.ricks.GuitarSpec.Wood;
import org.testng.annotations.Test;

public class FindGuitarTest {

	@Test
	public void searchForGuitar() {
		Inventory inventory = new Inventory();
		initialize(inventory);
		GuitarSpec whatErinLikes = new GuitarSpec.SpecBuilder()
											.builder(Builder.FENDER)
											.model("Stratocastor")
											.type(Type.ELECTRIC)
											.backWood(Wood.ALDER)
											.topWood(Wood.ALDER)
											.numStrings(12)
											.build();
		
		Collection<Guitar> guitars = inventory.search(whatErinLikes);
		if (guitars.isEmpty()) {
			System.out.println("Sorry, Erin, we have nothing for you.");
		} else {
			for (Guitar guitar : guitars) {
				GuitarSpec guitarSpec = guitar.getSpec();
				System.out.println("Erin, you might like this " +
						guitarSpec.getBuilder() + " " + guitarSpec.getModel() + " " +
						guitarSpec.getType() + " guitar:\n   " +
						guitarSpec.getNumStrings() + " strings,\n   " +
						guitarSpec.getBackWood() + " back and sides,\n   " +
						guitarSpec.getTopWood() + " top.\nYou can have it for only $" +
						guitar.getPrice() + "!");
			}
		}
	}

	private void initialize(Inventory inventory) {
		GuitarSpec spec1 = new GuitarSpec.SpecBuilder()
							.builder(Builder.FENDER)
							.model("Stratocastor")
							.type(Type.ELECTRIC)
							.backWood(Wood.ALDER)
							.topWood(Wood.ALDER)
							.numStrings(12)
							.build();
		GuitarSpec spec2 = new GuitarSpec.SpecBuilder()
							.builder(Builder.FENDER)
							.model("Stratocastor")
							.type(Type.ELECTRIC)
							.backWood(Wood.ALDER)
							.topWood(Wood.ALDER)
							.numStrings(12)
							.build();
		
		inventory.addGuitar("V95963", 1499.95, spec1);
		inventory.addGuitar("V9512", 1549.95, spec2);
	}
}
