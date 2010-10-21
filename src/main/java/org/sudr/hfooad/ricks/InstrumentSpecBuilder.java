package org.sudr.hfooad.ricks;

import java.util.HashMap;
import java.util.Map;

import org.sudr.hfooad.ricks.InstrumentSpec.Builder;
import org.sudr.hfooad.ricks.InstrumentSpec.MandolinStyle;
import org.sudr.hfooad.ricks.InstrumentSpec.Type;
import org.sudr.hfooad.ricks.InstrumentSpec.Wood;

class InstrumentSpecBuilder {

	private Map<String, Object> properties = new HashMap<String, Object>();

	public Map<String, Object> getProperties() {
		return properties;
	}
	
	public InstrumentSpecBuilder builder(Builder builder) {
		properties.put("builder", builder);
		return this;
	}

	public InstrumentSpecBuilder model(String model) {
		properties.put("model", model);
		return this;
	}

	public InstrumentSpecBuilder type(Type type) {
		properties.put("type", type);
		return this;
	}

	public InstrumentSpecBuilder backWood(Wood backWood) {
		properties.put("backWood", backWood);
		return this;
	}

	public InstrumentSpecBuilder topWood(Wood topWood) {
		properties.put("topWood", topWood);
		return this;
	}

	public InstrumentSpecBuilder numStrings(int numStrings) {
		properties.put("numStrings", numStrings);
		return this;
	}

	public InstrumentSpecBuilder style(MandolinStyle style) {
		properties.put("style", style);
		return this;
	}
	
	public InstrumentSpec build() {
		return new InstrumentSpec(this);
	}
	
}