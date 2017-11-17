package dum.org.hibernate.type.descriptor.java;

import java.util.Comparator;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.java.MutabilityPlan;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyJavaTypeDescriptor<T> extends TestEventCollector implements JavaTypeDescriptor<T> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private RunnableWithArgs wrapRWA;

	@SuppressWarnings("rawtypes")
	private RunnableWithArgs unwrapRWA;

	private Class<T> javaTypeClass;
	private MutabilityPlan<T> mutabilityPlan;

	private Comparator<T> comparator;

	@Override
	public Class<T> getJavaTypeClass() {
		return javaTypeClass;
	}

	public void setJavaTypeClass(Class<T> javaTypeClass) {
		this.javaTypeClass = javaTypeClass;
	}

	@Override
	public MutabilityPlan<T> getMutabilityPlan() {
		return mutabilityPlan;
	}

	public void setMutabilityPlan(MutabilityPlan<T> mutabilityPlan) {
		this.mutabilityPlan = mutabilityPlan;
	}

	@Override
	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public int extractHashCode(T value) {
		testEvents.add(new TestEvent("extractHashCode").prop("value", value));
		return 0;
	}

	@Override
	public boolean areEqual(T one, T another) {
		testEvents.add(new TestEvent("areEqual").prop("one", one).prop("another", another));
		return false;
	}

	@Override
	public String extractLoggableRepresentation(T value) {
		testEvents.add(new TestEvent("extractLoggableRepresentation").prop("value", value));
		return null;
	}

	@Override
	public String toString(T value) {
		testEvents.add(new TestEvent("toString").prop("value", value));
		return null;
	}

	@Override
	public T fromString(String string) {
		testEvents.add(new TestEvent("fromString").prop("string", string));
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <X> T wrap(X value, WrapperOptions options) {
		testEvents.add(new TestEvent("wrap").prop("value", value).prop("options", options));
		if (wrapRWA != null) {
			return (T) wrapRWA.run(value, options);
		}
		return null;
	}

	public void setWrapRWA(@SuppressWarnings("rawtypes") RunnableWithArgs wrapRWA) {
		this.wrapRWA = wrapRWA;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <X> X unwrap(T value, Class<X> type, WrapperOptions options) {
		testEvents.add(new TestEvent("unwrap").prop("value", value).prop("type", type).prop("options", options));
		if (unwrapRWA != null) {
			return (X) unwrapRWA.run(value, type, options);
		}
		return null;
	}

	public void setUnwrapRWA(@SuppressWarnings("rawtypes") RunnableWithArgs unwrapRWA) {
		this.unwrapRWA = unwrapRWA;
	}

}
