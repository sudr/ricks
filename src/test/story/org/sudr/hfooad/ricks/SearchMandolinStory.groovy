package org.sudr.hfooad.ricks;

import org.sudr.hfooad.ricks.InstrumentSpec.Builder;
import org.sudr.hfooad.ricks.InstrumentSpec.Type;
import org.sudr.hfooad.ricks.InstrumentSpec.Wood;
import org.sudr.hfooad.ricks.MandolinSpec.Style;

shared_behavior "shared behaviors", {
	given "a stocked inventory", {
	  inventory = new Inventory()
	  
	  guitarSpec = new GuitarSpec.GuitarSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .numStrings(12)
						  .build()
	  inventory.addInstrument 'G001', 1199.0, guitarSpec
	  
	  mandolinSpec = new MandolinSpec.MandolinSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .style(Style.A)
						  .build()
	  inventory.addInstrument 'M001', 1499.0, mandolinSpec
	  
	  guitarSpec = new GuitarSpec.GuitarSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .numStrings(12)
						  .build()
	  inventory.addInstrument 'G002', 1299.0, guitarSpec
	  
	  mandolinSpec = new MandolinSpec.MandolinSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .style(Style.A)
						  .build()
      inventory.addInstrument 'M002', 1099.0, mandolinSpec
	}
}

scenario "searching for a mandolin that exists in the inventory", {
    it_behaves_as "shared behaviors"

    when "I search for the M002 mandolin", {
		mandolinSpec = new MandolinSpec.MandolinSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .style(Style.A)
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
		mandolinSpec = new MandolinSpec.MandolinSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .style(Style.A)
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
		mandolinSpec = new MandolinSpec.MandolinSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .style(Style.F)
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
		mandolinSpec = new MandolinSpec.MandolinSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.MAHOGANY)
						  .topWood(Wood.ALDER)
						  .style(Style.A)
						  .build()
		mandolins = inventory.search(mandolinSpec)
	}

	then "I must not get any matches", {
		assert mandolins.size() == 0
	}
}