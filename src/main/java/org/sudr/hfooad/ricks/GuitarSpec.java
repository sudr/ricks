package org.sudr.hfooad.ricks;




public class GuitarSpec {
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

	static class SpecBuilder {

		private Wood topWood;
		private Wood backWood;
		private Type type;
		private String model;
		private Builder builder;

		public GuitarSpec build() {
			return new GuitarSpec(this);
		}

		public SpecBuilder builder(Builder builder) {
			this.builder = builder;
			return this;
		}

		public SpecBuilder model(String model) {
			this.model = model;
			return this;
		}

		public SpecBuilder type(Type type) {
			this.type = type;
			return this;
		}

		public SpecBuilder backWood(Wood backWood) {
			this.backWood = backWood;
			return this;
		}
		
		public SpecBuilder topWood(Wood topWood) {
			this.topWood = topWood;
			return this;
		}

	}

	private Builder builder;
	private String model;
	private Type type;
	private Wood backWood;
	private Wood topWood;

	public GuitarSpec(SpecBuilder specBuilder) {
		this.builder = specBuilder.builder;
		this.model = specBuilder.model;
		this.type = specBuilder.type;
		this.backWood = specBuilder.backWood;
		this.topWood = specBuilder.topWood;
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
}
