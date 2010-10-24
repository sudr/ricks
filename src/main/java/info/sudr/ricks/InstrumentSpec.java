package info.sudr.ricks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

public class InstrumentSpec {

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

	public enum MandolinStyle {
		A, F
	}

	private Map<String, Object> properties;

	public InstrumentSpec(InstrumentSpecBuilder specBuilder) {
		if (specBuilder == null || specBuilder.getProperties() == null) {
			this.properties = new HashMap<String, Object>();
		} else {
			this.properties = specBuilder.getProperties();
		}
	}

	public InstrumentSpec(Map<String, Object> properties) {
		this.properties = properties;
	}

	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}
	
	public Map<String, Object> getProperties() {
		return Collections.unmodifiableMap(properties);
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
		
		for (String propertyName : other.getProperties().keySet()) {
			if (!other.getProperty(propertyName).equals(getProperty(propertyName))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(properties).toString();
	}
}