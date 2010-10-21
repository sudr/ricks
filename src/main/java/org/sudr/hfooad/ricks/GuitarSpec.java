package org.sudr.hfooad.ricks;

import org.apache.commons.lang.builder.ToStringBuilder;

public class GuitarSpec extends InstrumentSpec {

	protected static class GuitarSpecBuilder {
		private int numStrings;
		private Wood topWood;
		private Wood backWood;
		private Type type;
		private String model;
		private Builder builder;

		public GuitarSpecBuilder builder(Builder builder) {
			this.builder = builder;
			return this;
		}

		public GuitarSpecBuilder model(String model) {
			this.model = model;
			return this;
		}

		public GuitarSpecBuilder type(Type type) {
			this.type = type;
			return this;
		}

		public GuitarSpecBuilder backWood(Wood backWood) {
			this.backWood = backWood;
			return this;
		}

		public GuitarSpecBuilder topWood(Wood topWood) {
			this.topWood = topWood;
			return this;
		}

		public GuitarSpecBuilder numStrings(int numStrings) {
			this.numStrings = numStrings;
			return this;
		}

		public GuitarSpec build() {
			return new GuitarSpec(this);
		}
	}

	private int numStrings;

	private GuitarSpec(GuitarSpecBuilder specBuilder) {
		super(specBuilder.builder, specBuilder.model, specBuilder.type, specBuilder.backWood, specBuilder.topWood);
		this.numStrings = specBuilder.numStrings;
	}

	public int getNumStrings() {
		return numStrings;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof GuitarSpec)) {
			return false;
		}
		GuitarSpec other = (GuitarSpec) obj;
		return getNumStrings() == other.getNumStrings();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString())
			.append(numStrings)
			.toString();
	}
}
