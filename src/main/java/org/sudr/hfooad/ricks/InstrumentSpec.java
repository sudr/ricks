package org.sudr.hfooad.ricks;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class InstrumentSpec {

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

	protected Builder builder;
	protected String model;
	protected Type type;
	protected Wood backWood;
	protected Wood topWood;

	public InstrumentSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
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

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof InstrumentSpec)) {
			return false;
		}
		InstrumentSpec other = (InstrumentSpec) obj;
		if (this.getBuilder() != other.getBuilder()) {
			return false;
		}
		String model = other.getModel();
		if (StringUtils.isNotBlank(model) && !StringUtils.equalsIgnoreCase(model, this.getModel())) {
			return false;
		}
		if (this.getType() != other.getType()) {
			return false;
		}
		if (this.getBackWood() != other.getBackWood()) {
			return false;
		}
		if (this.getTopWood() != other.getTopWood()) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append(model)
			.append(type)
			.append(backWood)
			.append(topWood)
			.toString();
	}
}