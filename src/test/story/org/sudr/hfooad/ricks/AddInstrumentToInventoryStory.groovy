package org.sudr.hfooad.ricks;

import org.sudr.hfooad.ricks.Instrument.InstrumentType;

shared_behavior "shared behaviors", {
	given "an inventory", {
	  inventory = new Inventory()
	}
}

scenario "adding a new guitar to the inventory", {
    it_behaves_as "shared behaviors"

    when "a guitar is added", {
		guitarSpec = new InstrumentSpecBuilder().build()
        inventory.addInstrument(InstrumentType.GUITAR, 'G001', 1000.0, guitarSpec)
    }

    then "the inventory must contain the guitar that was added", {
        inventory.size.equals 1
		inventory['G001'].spec.shouldEqual guitarSpec
    }
}

scenario "adding a new mandolin to the inventory", {
	it_behaves_as "shared behaviors"

	when "a mandolin is added", {
		mandolinSpec = new InstrumentSpecBuilder().build()
		inventory.addInstrument(InstrumentType.MANDOLIN, 'M001', 1000.0, mandolinSpec)
	}

	then "the inventory must contain the mandolin that was added", {
		inventory.size.equals 1
		inventory['M001'].spec.shouldEqual mandolinSpec
	}
}
