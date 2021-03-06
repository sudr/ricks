package info.sudr.ricks;

import info.sudr.ricks.InstrumentSpec.Builder;
import info.sudr.ricks.InstrumentSpec.Type;
import info.sudr.ricks.InstrumentSpec.Wood;
import info.sudr.ricks.InstrumentSpec.MandolinStyle;
import info.sudr.ricks.Instrument.InstrumentType;

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

scenario "searching for a guitar that exists in inventory", {
    it_behaves_as "shared behaviors"

    when "I search for a guitar that is in inventory", {
		guitarSpec = new InstrumentSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .numStrings(12)
						  .build()
        guitars = inventory.search(guitarSpec)
    }

    then "the guitar must be available", {
		assert guitars.size() > 0
    }
}

scenario "searching for a guitar with multiple matches in inventory", {
	it_behaves_as "shared behaviors"

	when "I search for a guitar with multiple matches", {
		guitarSpec = new InstrumentSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .numStrings(12)
						  .build()
		guitars = inventory.search(guitarSpec)
	}

	then "I must get all matches", {
		assert guitars.size() == 2
	}
}

scenario "searching for a guitar with 20 strings", {
	it_behaves_as "shared behaviors"

	when "I search for a guitar with 20 strings", {
		guitarSpec = new InstrumentSpecBuilder()
						  .builder(Builder.FENDER)
						  .model("Stratocastor")
						  .type(Type.ELECTRIC)
						  .backWood(Wood.ALDER)
						  .topWood(Wood.ALDER)
						  .numStrings(22)
						  .build()
		guitars = inventory.search(guitarSpec)
	}
	
	then "I must not get any matches", {
		assert guitars.size() == 0
	}
}

scenario "searching for a guitar with Mahogany backwood", {
	it_behaves_as "shared behaviors"

	when "I search for a guitar with Mahogany backwood", {
		guitarSpec = new InstrumentSpecBuilder()
					  .builder(Builder.FENDER)
					  .model("Stratocastor")
					  .type(Type.ELECTRIC)
					  .backWood(Wood.MAHOGANY)
					  .topWood(Wood.ALDER)
					  .numStrings(22)
					  .build()
	    guitars = inventory.search(guitarSpec)
	}
	
	then "I must not get any matches", {
		assert guitars.size() == 0
	}
}