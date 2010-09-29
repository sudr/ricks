package org.sudr.hfooad.ricks;

import java.util.Collection;

import org.sudr.hfooad.ricks.Guitar.Builder;
import org.sudr.hfooad.ricks.Guitar.Type;
import org.sudr.hfooad.ricks.Guitar.Wood;
import org.testng.annotations.Test;

public class FindGuitarTest {

	@Test
	public void searchForGuitar() {
		Inventory inventory = new Inventory();
		initialize(inventory);
		Guitar whatErinLikes = new Guitar("", 0, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		
		Collection<Guitar> guitars = inventory.search(whatErinLikes);
		if (guitars.isEmpty()) {
			System.out.println("Sorry, Erin, we have nothing for you.");
		} else {
			for (Guitar guitar : guitars) {
				System.out.println("Erin, you might like this " +
						guitar.getBuilder() + " " + guitar.getModel() + " " +
						guitar.getType() + " guitar:\n   " +
						guitar.getBackWood() + " back and sides,\n   " +
						guitar.getTopWood() + " top.\nYou can have it for only $" +
						guitar.getPrice() + "!");
			}
		}
	}

	private void initialize(Inventory inventory) {
		inventory.addGuitar("V95963", 1499.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		inventory.addGuitar("V9512", 1549.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
	}
}
