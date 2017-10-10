package dum.org.springframework.expression;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.TypeConverter;

public class DummyTypeConverter implements TypeConverter {

	private boolean canConvert;
	private Object convertedValue;
	private boolean identity = false;
	private List<Object[]> mappings;

	@Override
	public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return canConvert;
	}

	@Override
	public Object convertValue(Object value, TypeDescriptor sourceType, TypeDescriptor targetType) {
		if (identity) {
			return value;
		}
		if (mappings != null) {
			for (Object o : mappings) {
				Object[] mapping = (Object[]) o;
				if (mapping[0] == value) {
					return mapping[1];
				}
			}
		}
		return convertedValue;
	}

	public void setCanConvert(boolean canConvert) {
		this.canConvert = canConvert;
	}

	public void setConvertedValue(Object convertedValue) {
		this.convertedValue = convertedValue;
	}

	public void setIdentity(boolean identity) {
		this.identity = identity;

	}

	public void setConvert(Object from, Object to) {
		if (mappings == null) {
			mappings = new ArrayList<>();
		}
		mappings.add(new Object[] { from, to });
	}

}
