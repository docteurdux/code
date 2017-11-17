package dum.org.hibernate.type.descriptor.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.java.MutabilityPlan;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyJavaTypeDescriptor<T> implements JavaTypeDescriptor<T> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private Map<Class<?>, RunnableWithArgs> unwrapRWAs = new HashMap<>();

	@Override
	public Class<T> getJavaTypeClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MutabilityPlan<T> getMutabilityPlan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<T> getComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int extractHashCode(T value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean areEqual(T one, T another) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String extractLoggableRepresentation(T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T fromString(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <X> X unwrap(T value, Class<X> type, WrapperOptions options) {
		@SuppressWarnings("unchecked")
		RunnableWithArgs<X> unwrapRWA = unwrapRWAs.get(type);
		if (unwrapRWA != null) {
			return unwrapRWA.run(value, type, options);
		}

		return null;
	}

	public <X> void setUnwrapRWA(Class<X> type, RunnableWithArgs<X> unwrapRWA) {
		unwrapRWAs.put(type, unwrapRWA);
	}

	@Override
	public <X> T wrap(X value, WrapperOptions options) {
		// TODO Auto-generated method stub
		return null;
	}

}
