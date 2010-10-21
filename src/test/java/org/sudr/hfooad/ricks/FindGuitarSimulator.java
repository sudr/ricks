package org.sudr.hfooad.ricks;

import java.util.Collection;

import org.sudr.hfooad.ricks.InstrumentSpec.Builder;
import org.sudr.hfooad.ricks.InstrumentSpec.Type;
import org.sudr.hfooad.ricks.InstrumentSpec.Wood;
import org.sudr.hfooad.ricks.MandolinSpec.Style;

public class FindGuitarSimulator {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		initialize(inventory);
		GuitarSpec whatErinLikes = new GuitarSpec.GuitarSpecBuilder()
											.builder(Builder.FENDER)
											.model("Stratocastor")
											.type(Type.ELECTRIC)
											.backWood(Wood.ALDER)
											.topWood(Wood.ALDER)
											.numStrings(12)
											.build();
		
		Collection<Instrument> guitars = inventory.search(whatErinLikes);
		if (guitars.isEmpty()) {
			System.out.println("Sorry, Erin, we have nothing for you.");
		} else {
			for (Instrument guitar : guitars) {
				GuitarSpec guitarSpec = (GuitarSpec) guitar.getSpec();
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

	private static void initialize(Inventory inventory) {
		GuitarSpec spec1 = new GuitarSpec.GuitarSpecBuilder()
							.builder(Builder.FENDER)
							.model("Stratocastor")
							.type(Type.ELECTRIC)
							.backWood(Wood.ALDER)
							.topWood(Wood.ALDER)
							.numStrings(12)
							.build();
		
		MandolinSpec spec2 = new MandolinSpec.MandolinSpecBuilder()
							.builder(Builder.FENDER)
							.model("Stratocastor")
							.type(Type.ELECTRIC)
							.backWood(Wood.ALDER)
							.topWood(Wood.ALDER)
							.style(Style.A)
							.build();
		
		GuitarSpec spec3 = new GuitarSpec.GuitarSpecBuilder()
							.builder(Builder.FENDER)
							.model("Stratocastor")
							.type(Type.ELECTRIC)
							.backWood(Wood.ALDER)
							.topWood(Wood.ALDER)
							.numStrings(12)
							.build();
		
		inventory.addInstrument("V95963", 1499.95, spec1);
		inventory.addInstrument("X12132", 800.95, spec2);
		inventory.addInstrument("V9512", 1549.95, spec3);
	}
}
