package org.sudr.hfooad.ricks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.apache.commons.lang.StringUtils;
import org.sudr.hfooad.ricks.Guitar.Builder;
import org.sudr.hfooad.ricks.Guitar.Type;
import org.sudr.hfooad.ricks.Guitar.Wood;

public class Inventory {

	private LinkedList<Guitar> guitars;

	public Inventory() {
		guitars = new LinkedList<Guitar>();
	}

	public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
		Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
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

	public Collection<Guitar> search(Guitar searchGuitar) {
		Collection<Guitar> matchingGuitars = new ArrayList<Guitar>();
		for (Guitar g : guitars) {
			// ignore serialNumber and price since those are unique
			if (g.getBuilder() != searchGuitar.getBuilder()) {
				continue;
			}
			String model = searchGuitar.getModel();
			if (StringUtils.isNotBlank(model) && !StringUtils.equalsIgnoreCase(model, g.getModel())) {
				continue;
			}
			if (g.getType() != searchGuitar.getType()) {
				continue;
			}
			if (g.getBackWood() != searchGuitar.getBackWood()) {
				continue;
			}
			if (g.getTopWood() != searchGuitar.getTopWood()) {
				continue;
			}
			matchingGuitars.add(g);
		}
		return matchingGuitars.isEmpty() ? Collections.<Guitar>emptyList() : matchingGuitars;
	}

}
