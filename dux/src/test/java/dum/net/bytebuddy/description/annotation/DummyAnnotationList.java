package dum.net.bytebuddy.description.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationDescription.Loadable;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatcher;

public class DummyAnnotationList implements AnnotationList {

	private Set<Class<?>> annotations = new HashSet<>();

	@Override
	public AnnotationList filter(ElementMatcher<? super AnnotationDescription> elementMatcher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotationDescription getOnly() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotationList subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<AnnotationDescription> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(AnnotationDescription e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends AnnotationDescription> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends AnnotationDescription> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public AnnotationDescription get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotationDescription set(int index, AnnotationDescription element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, AnnotationDescription element) {
		// TODO Auto-generated method stub

	}

	@Override
	public AnnotationDescription remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<AnnotationDescription> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<AnnotationDescription> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
		return annotations.contains(annotationType);
	}

	public void setAnnotationPresent(Class<?> clazz, boolean present) {
		if (present) {
			annotations.add(clazz);
		} else {
			annotations.remove(clazz);
		}
	}

	@Override
	public boolean isAnnotationPresent(TypeDescription annotationType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T extends Annotation> Loadable<T> ofType(Class<T> annotationType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotationDescription ofType(TypeDescription annotationType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotationList inherited(Set<? extends TypeDescription> ignoredTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotationList visibility(ElementMatcher<? super RetentionPolicy> matcher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeList asTypeList() {
		// TODO Auto-generated method stub
		return null;
	}

}
