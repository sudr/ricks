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

	public Collection<Guitar> search(GuitarSpec searchSpec) {
		Collection<Guitar> matchingGuitars = new ArrayList<Guitar>();
		for (Instrument g : inventory) {
			if (g.getSpec().equals(searchSpec)) {
				matchingGuitars.add((Guitar) g);
			}
		}
		return matchingGuitars.isEmpty() ? Collections.<Guitar> emptyList() : Collections.unmodifiableCollection(matchingGuitars);
	}
	
	public Collection<Mandolin> search(MandolinSpec searchSpec) {
		Collection<Mandolin> matchingMandolins = new ArrayList<Mandolin>();
		for (Instrument m : inventory) {
			if (m.getSpec().equals(searchSpec)) {
				matchingMandolins.add((Mandolin) m);
			}
		}
		return matchingMandolins.isEmpty() ? Collections.<Mandolin> emptyList() : Collections.unmodifiableCollection(matchingMandolins);
	}
}
