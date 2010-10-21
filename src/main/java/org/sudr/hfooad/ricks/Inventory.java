package org.sudr.hfooad.ricks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Inventory {

	private LinkedList<Instrument> inventory;

	public Inventory() {
		inventory = new LinkedList<Instrument>();
	}

	public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
		Instrument instrument = null;
		if (spec instanceof GuitarSpec) {
			instrument = new Guitar(serialNumber, price, (GuitarSpec) spec);
		} else if (spec instanceof MandolinSpec) {
			instrument = new Mandolin(serialNumber, price, (MandolinSpec) spec);
		}
		
		if (instrument != null) {
			inventory.add(instrument);
		}
	}

	public Instrument get(String serialNumber) {
		for (Instrument instr : inventory) {
			if (instr.getSerialNumber().equals(serialNumber)) {
				return instr;
			}
		}
		return null;
	}

	public Collection<Instrument> search(InstrumentSpec searchSpec) {
		Collection<Instrument> matches = new ArrayList<Instrument>();
		for (Instrument inst : inventory) {
			if (inst.getSpec().equals(searchSpec)) {
				matches.add(inst);
			}
		}
		return matches.isEmpty() ? Collections.<Instrument> emptyList() : Collections.unmodifiableCollection(matches);
	}
}
