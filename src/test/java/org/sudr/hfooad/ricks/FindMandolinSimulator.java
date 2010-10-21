package org.sudr.hfooad.ricks;

import java.util.Collection;

import org.sudr.hfooad.ricks.Instrument.InstrumentType;
import org.sudr.hfooad.ricks.InstrumentSpec.Builder;
import org.sudr.hfooad.ricks.InstrumentSpec.MandolinStyle;
import org.sudr.hfooad.ricks.InstrumentSpec.Type;
import org.sudr.hfooad.ricks.InstrumentSpec.Wood;

public class FindMandolinSimulator {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		initialize(inventory);
		InstrumentSpec whatErinLikes = new InstrumentSpecBuilder()
											.builder(Builder.FENDER)
											.model("Stratocastor")
											.type(Type.ELECTRIC)
											.backWood(Wood.ALDER)
											.topWood(Wood.ALDER)
											.style(MandolinStyle.A)
											.build();
		
		Collection<Instrument> mandolins = inventory.search(whatErinLikes);
		if (mandolins.isEmpty()) {
			System.out.println("Sorry, Erin, we have nothing for you.");
		} else {
			for (Instrument mandolin : mandolins) {
				InstrumentSpec mandolinSpec = mandolin.getSpec();
				System.out.println("Erin, you might like this " +
						mandolinSpec.getProperty("builder") + " " + mandolinSpec.getProperty("model") + " " +
						mandolinSpec.getProperty("type") + " mandolin:\n   " +
						mandolinSpec.getProperty("style") + " style,\n   " +
						mandolinSpec.getProperty("backWood") + " back and sides,\n   " +
						mandolinSpec.getProperty("topWood") + " top.\nYou can have it for only $" +
						mandolin.getPrice() + "!");
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
