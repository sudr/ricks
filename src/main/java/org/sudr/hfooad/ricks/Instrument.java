package org.sudr.hfooad.ricks;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class Instrument {

	private final double price;
	private final String serialNumber;
	private final InstrumentSpec spec;

	public Instrument(String serialNumber, double price, InstrumentSpec spec) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.spec = spec;
	}

	public double getPrice() {
		return price;
	}

	public String getSerialNumber() {
		return serialNumber;
	}
	
	public InstrumentSpec getSpec() {
		return spec;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(serialNumber)
			.append(price)
			.append(spec)
			.toString();
	}
}
