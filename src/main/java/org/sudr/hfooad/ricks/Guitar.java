package org.sudr.hfooad.ricks;

public class Guitar {

	public enum Type {
		ACOUSTIC, ELECTRIC;

		@Override
		public String toString() {
			switch (this) {
			case ACOUSTIC:
				return "acoustic";
			case ELECTRIC:
				return "electric";
			default:
				throw new RuntimeException("unknown type");
			}
		}
	}

	public enum Builder {
		FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

		@Override
		public String toString() {
			switch (this) {
			case FENDER:
				return "Fender";
			case MARTIN:
				return "Martin";
			case GIBSON:
				return "Gibson";
			case COLLINGS:
				return "Collings";
			case OLSON:
				return "Olson";
			case RYAN:
				return "Ryan";
			case PRS:
				return "Prs";
			case ANY:
				return "Any";
			default:
				throw new RuntimeException("unknown type");
			}
		}
	}

	public enum Wood {
		INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;
		
		@Override
		public String toString() {
			switch (this) {
			case INDIAN_ROSEWOOD:
				return "Indian Rosewood";
			case BRAZILIAN_ROSEWOOD:
				return "Brazilian Rosewood";
			case MAHOGANY:
				return "Mahogany";
			case MAPLE:
				return "Maple";
			case COCOBOLO:
				return "Cocobolo";
			case CEDAR:
				return "Cedar";
			case ADIRONDACK:
				return "Adirondack";
			case ALDER:
				return "Alder";
			case SITKA:
				return "Sitka";
			default:
				throw new RuntimeException("unknown type");
			}
		}
	}

	private Builder builder;
	private String model;
	private Type type;
	private Wood backWood;
	private Wood topWood;
	private double price;
	private final String serialNumber;

	public Guitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public Builder getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public Type getType() {
		return type;
	}

	public Wood getBackWood() {
		return backWood;
	}

	public Wood getTopWood() {
		return topWood;
	}

	public double getPrice() {
		return price;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

}
