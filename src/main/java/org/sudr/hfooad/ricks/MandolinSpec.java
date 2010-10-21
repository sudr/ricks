package org.sudr.hfooad.ricks;

import org.apache.commons.lang.builder.ToStringBuilder;

public class MandolinSpec extends InstrumentSpec {

	public enum Style {
		A, F
	}

	protected static class MandolinSpecBuilder {
		private Style style;
		private Wood topWood;
		private Wood backWood;
		private Type type;
		private String model;
		private Builder builder;

		public MandolinSpecBuilder builder(Builder builder) {
			this.builder = builder;
			return this;
		}

		public MandolinSpecBuilder model(String model) {
			this.model = model;
			return this;
		}

		public MandolinSpecBuilder type(Type type) {
			this.type = type;
			return this;
		}

		public MandolinSpecBuilder backWood(Wood backWood) {
			this.backWood = backWood;
			return this;
		}

		public MandolinSpecBuilder topWood(Wood topWood) {
			this.topWood = topWood;
			return this;
		}

		public MandolinSpecBuilder style(Style style) {
			this.style = style;
			return this;
		}

		public MandolinSpec build() {
			return new MandolinSpec(this);
		}
	}

	private Style style;

	public MandolinSpec(MandolinSpecBuilder specBuilder) {
		super(specBuilder.builder, specBuilder.model, specBuilder.type, specBuilder.backWood, specBuilder.topWood);
		this.style = specBuilder.style;
	}

	public Style getStyle() {
		return style;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof MandolinSpec)) {
			return false;
		}
		MandolinSpec other = (MandolinSpec) obj;
		if (getStyle() == other.getStyle()) {
			return true;
		}
		return getStyle().equals(other.getStyle());
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString())
			.append(style)
			.toString();
	}
}
