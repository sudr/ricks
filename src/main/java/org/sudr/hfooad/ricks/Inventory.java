package org.sudr.hfooad.ricks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.apache.commons.lang.StringUtils;
import org.sudr.hfooad.ricks.GuitarSpec.Builder;
import org.sudr.hfooad.ricks.GuitarSpec.Type;
import org.sudr.hfooad.ricks.GuitarSpec.Wood;

public class Inventory {

	private LinkedList<Guitar> guitars;

	public Inventory() {
		guitars = new LinkedList<Guitar>();
	}

	public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
		GuitarSpec spec = new GuitarSpec.SpecBuilder()
									.builder(builder)
									.model(model)
									.type(type)
									.backWood(backWood)
									.topWood(topWood)
									.build();
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
			// ignore serialNumber and price since those are unique
			GuitarSpec guitarSpec = g.getSpec();
			if (guitarSpec.getBuilder() != searchSpec.getBuilder()) {
				continue;
			}
			String model = searchSpec.getModel();
			if (StringUtils.isNotBlank(model) && !StringUtils.equalsIgnoreCase(model, guitarSpec.getModel())) {
				continue;
			}
			if (guitarSpec.getType() != searchSpec.getType()) {
				continue;
			}
			if (guitarSpec.getBackWood() != searchSpec.getBackWood()) {
				continue;
			}
			if (guitarSpec.getTopWood() != searchSpec.getTopWood()) {
				continue;
			}
			matchingGuitars.add(g);
		}
		return matchingGuitars.isEmpty() ? Collections.<Guitar>emptyList() : matchingGuitars;
	}

}
