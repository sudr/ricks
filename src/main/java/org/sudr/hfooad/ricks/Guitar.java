package org.sudr.hfooad.ricks;



public class Guitar {

	private GuitarSpec spec = new GuitarSpec.SpecBuilder().build();
	private double price;
	private final String serialNumber;

	public Guitar(String serialNumber, double price, GuitarSpec spec) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.spec = spec;
	}

	public GuitarSpec getSpec() {
		return spec;
	}

	public double getPrice() {
		return price;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

}
