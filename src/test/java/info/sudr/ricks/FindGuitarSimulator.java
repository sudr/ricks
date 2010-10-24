package info.sudr.ricks;

import info.sudr.ricks.Instrument;
import info.sudr.ricks.InstrumentSpec;
import info.sudr.ricks.InstrumentSpecBuilder;
import info.sudr.ricks.Inventory;
import info.sudr.ricks.Instrument.InstrumentType;
import info.sudr.ricks.InstrumentSpec.Builder;
import info.sudr.ricks.InstrumentSpec.MandolinStyle;
import info.sudr.ricks.InstrumentSpec.Type;
import info.sudr.ricks.InstrumentSpec.Wood;

import java.util.Collection;


public class FindGuitarSimulator {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		initialize(inventory);
		InstrumentSpec whatErinLikes = new InstrumentSpecBuilder()
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
				InstrumentSpec guitarSpec = guitar.getSpec();
				System.out.println("Erin, you might like this " +
						guitarSpec.getProperty("builder") + " " + guitarSpec.getProperty("model") + " " +
						guitarSpec.getProperty("type") + " guitar:\n   " +
						guitarSpec.getProperty("numStrings") + " strings,\n   " +
						guitarSpec.getProperty("backWood") + " back and sides,\n   " +
						guitarSpec.getProperty("topWood") + " top.\nYou can have it for only $" +
						guitar.getPrice() + "!");
			}
		}
	}

	private static void initialize(Inventory inventory) {
		InstrumentSpec spec1 = new InstrumentSpecBuilder()
							.builder(Builder.FENDER)
							.model("Stratocastor")
							.type(Type.ELECTRIC)
							.backWood(Wood.ALDER)
							.topWood(Wood.ALDER)
							.numStrings(12)
							.build();
		
		InstrumentSpec spec2 = new InstrumentSpecBuilder()
							.builder(Builder.FENDER)
							.model("Stratocastor")
							.type(Type.ELECTRIC)
							.backWood(Wood.ALDER)
							.topWood(Wood.ALDER)
							.style(MandolinStyle.A)
							.build();
		
		InstrumentSpec spec3 = new InstrumentSpecBuilder()
							.builder(Builder.FENDER)
							.model("Stratocastor")
							.type(Type.ELECTRIC)
							.backWood(Wood.ALDER)
							.topWood(Wood.ALDER)
							.numStrings(12)
							.build();
		
		inventory.addInstrument(InstrumentType.GUITAR, "V95963", 1499.95, spec1);
		inventory.addInstrument(InstrumentType.MANDOLIN, "X12132", 800.95, spec2);
		inventory.addInstrument(InstrumentType.GUITAR, "V9512", 1549.95, spec3);
	}
}
