package org.sudr.hfooad.ricks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Inventory {

	private LinkedList<Guitar> guitars;

	public Inventory() {
		guitars = new LinkedList<Guitar>();
	}

	public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
		Guitar guitar = new Guitar(serialNumber, price, spec);
		guitars.add(guitar);
	}

	public Guitar getGuitar(String serialNumber) {
		for (Guitar g : guitars) {
			if (g.getSerialNumber().equals(serialNumber)) {
				return g;
			}
		}
		return null;
	}

	public Collection<Guitar> search(GuitarSpec searchSpec) {
		Collection<Guitar> matchingGuitars = new ArrayList<Guitar>();
		for (Guitar g : guitars) {
			if (g.getSpec().equals(searchSpec)) {
				matchingGuitars.add(g);
			}
		}
		return matchingGuitars.isEmpty() ? Collections.<Guitar> emptyList() : matchingGuitars;
	}
}
