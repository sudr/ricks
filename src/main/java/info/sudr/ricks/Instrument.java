package info.sudr.ricks;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Instrument {

	public enum InstrumentType {
		GUITAR, MANDOLIN, VIOLIN
	}

	private final InstrumentType instrumentType;
	private final double price;
	private final String serialNumber;
	private final InstrumentSpec spec;

	public Instrument(InstrumentType instrumentType, String serialNumber, double price, InstrumentSpec spec) {
		this.instrumentType = instrumentType;
		this.serialNumber = serialNumber;
		this.price = price;
		this.spec = spec;
	}

	public InstrumentType getInstrumentType() {
		return instrumentType;
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
