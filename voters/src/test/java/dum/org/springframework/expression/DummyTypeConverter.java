package dum.org.springframework.expression;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.TypeConverter;

public class DummyTypeConverter implements TypeConverter {

	private boolean canConvert;
	private Object convertedValue;

	@Override
	public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return canConvert;
	}

	@Override
	public Object convertValue(Object value, TypeDescriptor sourceType, TypeDescriptor targetType) {
		return convertedValue;
	}

	public void setCanConvert(boolean canConvert) {
		this.canConvert = canConvert;
	}

	public void setConvertedValue(Object convertedValue) {
		this.convertedValue = convertedValue;
	}

}
