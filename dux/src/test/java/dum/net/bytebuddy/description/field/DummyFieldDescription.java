package dum.net.bytebuddy.description.field;

import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.modifier.EnumerationState;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.FieldPersistence;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.SyntheticState;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeDescription.Generic;
import net.bytebuddy.matcher.ElementMatcher;

public class DummyFieldDescription implements FieldDescription {

	private AnnotationList annotationList;

	@Override
	public String getDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGenericSignature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isVisibleTo(TypeDescription typeDescription) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccessibleTo(TypeDescription typeDescription) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInternalName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getActualName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getModifiers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isFinal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSynthetic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SyntheticState getSyntheticState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDefinition getDeclaringType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotationList getDeclaredAnnotations() {
		return annotationList;
	}

	public void setAnnotationList(AnnotationList annotationList) {
		this.annotationList = annotationList;
	}

	@Override
	public boolean isVolatile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTransient() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FieldManifestation getFieldManifestation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FieldPersistence getFieldPersistence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnum() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EnumerationState getEnumerationState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPublic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProtected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPackagePrivate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrivate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStatic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDeprecated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ownership getOwnership() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Visibility getVisibility() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toGenericString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InDefinedShape asDefined() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Token asToken(ElementMatcher<? super TypeDescription> matcher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Generic getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getActualModifiers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SignatureToken asSignatureToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
