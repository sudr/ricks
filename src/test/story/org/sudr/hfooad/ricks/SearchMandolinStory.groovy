package org.sudr.hfooad.ricks;

import org.sudr.hfooad.ricks.InstrumentSpec.Builder;
import org.sudr.hfooad.ricks.InstrumentSpec.Type;
import org.sudr.hfooad.ricks.InstrumentSpec.Wood;
import org.sudr.hfooad.ricks.InstrumentSpec.MandolinStyle;
import org.sudr.hfooad.ricks.Instrument.InstrumentType;

shared_behavior "shared behaviors", {
	given "a stocked inventory", {
	  inventory = new Inventory()
	  
	  guitarSpec = new InstrumentSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .numStrings(12)
						  .build()
	  inventory.addInstrument InstrumentType.GUITAR, 'G001', 1199.0, guitarSpec
	  
	  mandolinSpec = new InstrumentSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .style(MandolinStyle.A)
						  .build()
	  inventory.addInstrument InstrumentType.MANDOLIN, 'M001', 1499.0, mandolinSpec
	  
	  guitarSpec = new InstrumentSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .numStrings(12)
						  .build()
	  inventory.addInstrument InstrumentType.GUITAR, 'G002', 1299.0, guitarSpec
	  
	  mandolinSpec = new InstrumentSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .style(MandolinStyle.A)
						  .build()
      inventory.addInstrument InstrumentType.MANDOLIN, 'M002', 1099.0, mandolinSpec
	}
}

scenario "searching for a mandolin that exists in the inventory", {
    it_behaves_as "shared behaviors"

    when "I search for the M002 mandolin", {
		mandolinSpec = new InstrumentSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .style(MandolinStyle.A)
						  .build()
        mandolins = inventory.search(mandolinSpec)
    }

    then "the mandolin must be available", {
		assert mandolins.size() > 0
    }
}

scenario "searching for a mandolin with multiple matches in the inventory", {
	it_behaves_as "shared behaviors"

	when "I search for the M002 mandolin", {
		mandolinSpec = new InstrumentSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .style(MandolinStyle.A)
						  .build()
		mandolins = inventory.search(mandolinSpec)
	}

	then "I must get all matches", {
		assert mandolins.size() == 2
	}
}

scenario "searching for a style F mandolin", {
	it_behaves_as "shared behaviors"

	when "I search for the style F mandolin", {
		mandolinSpec = new InstrumentSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .style(MandolinStyle.F)
						  .build()
		mandolins = inventory.search(mandolinSpec)
	}

	then "I must not get any matches", {
		assert mandolins.size() == 0
	}
}

scenario "searching for a mandolin with Mahogany backwood", {
	it_behaves_as "shared behaviors"

	when "I search for the style F mandolin", {
		mandolinSpec = new InstrumentSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.MAHOGANY)
						  .topWood(Wood.ALDER)
						  .style(MandolinStyle.A)
						  .build()
		mandolins = inventory.search(mandolinSpec)
	}

	then "I must not get any matches", {
		assert mandolins.size() == 0
	}
}