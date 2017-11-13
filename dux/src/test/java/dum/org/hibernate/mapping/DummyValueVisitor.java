package dum.org.hibernate.mapping;

import org.hibernate.mapping.Any;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.Bag;
import org.hibernate.mapping.Component;
import org.hibernate.mapping.DependantValue;
import org.hibernate.mapping.IdentifierBag;
import org.hibernate.mapping.List;
import org.hibernate.mapping.ManyToOne;
import org.hibernate.mapping.Map;
import org.hibernate.mapping.OneToMany;
import org.hibernate.mapping.OneToOne;
import org.hibernate.mapping.PrimitiveArray;
import org.hibernate.mapping.Set;
import org.hibernate.mapping.SimpleValue;
import org.hibernate.mapping.ValueVisitor;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyValueVisitor extends TestEventCollector implements ValueVisitor {

	@Override
	public Object accept(Bag object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(IdentifierBag object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(List object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(PrimitiveArray object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(Array object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(Map object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(OneToMany object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(Set object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(Any object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(SimpleValue object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(DependantValue object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(Component object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(ManyToOne object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

	@Override
	public Object accept(OneToOne object) {
		testEvents.add(new TestEvent("accept").prop("object", object));
		return null;
	}

}
