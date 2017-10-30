package dux.org.apache.ws.commons.schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ws.commons.schema.SchemaBuilder;
import org.apache.ws.commons.schema.TypeReceiver;
import org.apache.ws.commons.schema.ValidationEvent;
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaAll;
import org.apache.ws.commons.schema.XmlSchemaAllMember;
import org.apache.ws.commons.schema.XmlSchemaAnnotated;
import org.apache.ws.commons.schema.XmlSchemaAnnotation;
import org.apache.ws.commons.schema.XmlSchemaAnnotationItem;
import org.apache.ws.commons.schema.XmlSchemaAny;
import org.apache.ws.commons.schema.XmlSchemaAnyAttribute;
import org.apache.ws.commons.schema.XmlSchemaAppInfo;
import org.apache.ws.commons.schema.XmlSchemaAttribute;
import org.apache.ws.commons.schema.XmlSchemaAttributeGroup;
import org.apache.ws.commons.schema.XmlSchemaAttributeGroupMember;
import org.apache.ws.commons.schema.XmlSchemaAttributeGroupRef;
import org.apache.ws.commons.schema.XmlSchemaAttributeOrGroupRef;
import org.apache.ws.commons.schema.XmlSchemaChoice;
import org.apache.ws.commons.schema.XmlSchemaChoiceMember;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaComplexContent;
import org.apache.ws.commons.schema.XmlSchemaComplexContentExtension;
import org.apache.ws.commons.schema.XmlSchemaComplexContentRestriction;
import org.apache.ws.commons.schema.XmlSchemaComplexType;
import org.apache.ws.commons.schema.XmlSchemaContent;
import org.apache.ws.commons.schema.XmlSchemaContentModel;
import org.apache.ws.commons.schema.XmlSchemaContentProcessing;
import org.apache.ws.commons.schema.XmlSchemaContentType;
import org.apache.ws.commons.schema.XmlSchemaDerivationMethod;
import org.apache.ws.commons.schema.XmlSchemaDocumentation;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.apache.ws.commons.schema.XmlSchemaEnumerationFacet;
import org.apache.ws.commons.schema.XmlSchemaException;
import org.apache.ws.commons.schema.XmlSchemaExternal;
import org.apache.ws.commons.schema.XmlSchemaFacet;
import org.apache.ws.commons.schema.XmlSchemaForm;
import org.apache.ws.commons.schema.XmlSchemaFractionDigitsFacet;
import org.apache.ws.commons.schema.XmlSchemaGroup;
import org.apache.ws.commons.schema.XmlSchemaGroupParticle;
import org.apache.ws.commons.schema.XmlSchemaGroupRef;
import org.apache.ws.commons.schema.XmlSchemaIdentityConstraint;
import org.apache.ws.commons.schema.XmlSchemaImport;
import org.apache.ws.commons.schema.XmlSchemaInclude;
import org.apache.ws.commons.schema.XmlSchemaItemWithRef;
import org.apache.ws.commons.schema.XmlSchemaItemWithRefBase;
import org.apache.ws.commons.schema.XmlSchemaKey;
import org.apache.ws.commons.schema.XmlSchemaKeyref;
import org.apache.ws.commons.schema.XmlSchemaLengthFacet;
import org.apache.ws.commons.schema.XmlSchemaMaxExclusiveFacet;
import org.apache.ws.commons.schema.XmlSchemaMaxInclusiveFacet;
import org.apache.ws.commons.schema.XmlSchemaMaxLengthFacet;
import org.apache.ws.commons.schema.XmlSchemaMinExclusiveFacet;
import org.apache.ws.commons.schema.XmlSchemaMinInclusiveFacet;
import org.apache.ws.commons.schema.XmlSchemaMinLengthFacet;
import org.apache.ws.commons.schema.XmlSchemaNotation;
import org.apache.ws.commons.schema.XmlSchemaNumericFacet;
import org.apache.ws.commons.schema.XmlSchemaObject;
import org.apache.ws.commons.schema.XmlSchemaParticle;
import org.apache.ws.commons.schema.XmlSchemaPatternFacet;
import org.apache.ws.commons.schema.XmlSchemaRedefine;
import org.apache.ws.commons.schema.XmlSchemaSequence;
import org.apache.ws.commons.schema.XmlSchemaSequenceMember;
import org.apache.ws.commons.schema.XmlSchemaSerializer;
import org.apache.ws.commons.schema.XmlSchemaSimpleContent;
import org.apache.ws.commons.schema.XmlSchemaSimpleContentExtension;
import org.apache.ws.commons.schema.XmlSchemaSimpleContentRestriction;
import org.apache.ws.commons.schema.XmlSchemaSimpleType;
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeContent;
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeList;
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeRestriction;
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeUnion;
import org.apache.ws.commons.schema.XmlSchemaTotalDigitsFacet;
import org.apache.ws.commons.schema.XmlSchemaType;
import org.apache.ws.commons.schema.XmlSchemaUnique;
import org.apache.ws.commons.schema.XmlSchemaUse;
import org.apache.ws.commons.schema.XmlSchemaWhiteSpaceFacet;
import org.apache.ws.commons.schema.XmlSchemaXPath;
import org.apache.ws.commons.schema.XmlSeverityType;
import org.apache.ws.commons.schema.constants.Constants;
import org.apache.ws.commons.schema.extensions.DefaultExtensionDeserializer;
import org.apache.ws.commons.schema.extensions.DefaultExtensionSerializer;
import org.apache.ws.commons.schema.extensions.ExtensionDeserializer;
import org.apache.ws.commons.schema.extensions.ExtensionRegistry;
import org.apache.ws.commons.schema.extensions.ExtensionSerializer;
import org.apache.ws.commons.schema.resolver.CollectionURIResolver;
import org.apache.ws.commons.schema.resolver.DefaultURIResolver;
import org.apache.ws.commons.schema.resolver.URIResolver;
import org.apache.ws.commons.schema.utils.CollectionFactory;
import org.apache.ws.commons.schema.utils.DOMUtil;
import org.apache.ws.commons.schema.utils.NamespaceContextOwner;
import org.apache.ws.commons.schema.utils.NamespaceMap;
import org.apache.ws.commons.schema.utils.NamespacePrefixList;
import org.apache.ws.commons.schema.utils.NodeNamespaceContext;
import org.apache.ws.commons.schema.utils.PrefixCollector;
import org.apache.ws.commons.schema.utils.TargetNamespaceValidator;
import org.apache.ws.commons.schema.utils.UtilObjects;
import org.apache.ws.commons.schema.utils.XDOMUtil;
import org.apache.ws.commons.schema.utils.XmlSchemaNamed;
import org.apache.ws.commons.schema.utils.XmlSchemaNamedImpl;
import org.apache.ws.commons.schema.utils.XmlSchemaNamedWithForm;
import org.apache.ws.commons.schema.utils.XmlSchemaNamedWithFormImpl;
import org.apache.ws.commons.schema.utils.XmlSchemaObjectBase;
import org.apache.ws.commons.schema.utils.XmlSchemaRef;
import org.apache.ws.commons.schema.utils.XmlSchemaRefBase;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class DUXSummaryTest extends AbstractTest {

	@Test
	public void test() {

		List<Class<?>> classes = new ArrayList<>();

		classes.addAll(Arrays.asList(new Class<?>[] { SchemaBuilder.class, TypeReceiver.class, ValidationEvent.class,
				XmlSchema.class, XmlSchemaAll.class, XmlSchemaAllMember.class, XmlSchemaAnnotated.class,
				XmlSchemaAnnotation.class, XmlSchemaAnnotationItem.class, XmlSchemaAny.class,
				XmlSchemaAnyAttribute.class, XmlSchemaAppInfo.class, XmlSchemaAttribute.class,
				XmlSchemaAttributeGroup.class, XmlSchemaAttributeGroupMember.class, XmlSchemaAttributeGroupRef.class,
				XmlSchemaAttributeOrGroupRef.class, XmlSchemaChoice.class, XmlSchemaChoiceMember.class,
				XmlSchemaCollection.class, XmlSchemaComplexContent.class, XmlSchemaComplexContentExtension.class,
				XmlSchemaComplexContentRestriction.class, XmlSchemaComplexType.class, XmlSchemaContent.class,
				XmlSchemaContentModel.class, XmlSchemaContentProcessing.class, XmlSchemaContentType.class,
				XmlSchemaDerivationMethod.class, XmlSchemaDocumentation.class, XmlSchemaElement.class,
				XmlSchemaEnumerationFacet.class, XmlSchemaException.class, XmlSchemaExternal.class,
				XmlSchemaFacet.class, XmlSchemaForm.class, XmlSchemaFractionDigitsFacet.class, XmlSchemaGroup.class,
				XmlSchemaGroupParticle.class, XmlSchemaGroupRef.class, XmlSchemaIdentityConstraint.class,
				XmlSchemaImport.class, XmlSchemaInclude.class, XmlSchemaItemWithRef.class,
				XmlSchemaItemWithRefBase.class, XmlSchemaKey.class, XmlSchemaKeyref.class, XmlSchemaLengthFacet.class,
				XmlSchemaMaxExclusiveFacet.class, XmlSchemaMaxInclusiveFacet.class, XmlSchemaMaxLengthFacet.class,
				XmlSchemaMinExclusiveFacet.class, XmlSchemaMinInclusiveFacet.class, XmlSchemaMinLengthFacet.class,
				XmlSchemaNotation.class, XmlSchemaNumericFacet.class, XmlSchemaObject.class, XmlSchemaParticle.class,
				XmlSchemaPatternFacet.class, XmlSchemaRedefine.class, XmlSchemaSequence.class,
				XmlSchemaSequenceMember.class, XmlSchemaSerializer.class, XmlSchemaSimpleContent.class,
				XmlSchemaSimpleContentExtension.class, XmlSchemaSimpleContentRestriction.class,
				XmlSchemaSimpleType.class, XmlSchemaSimpleTypeContent.class, XmlSchemaSimpleTypeList.class,
				XmlSchemaSimpleTypeRestriction.class, XmlSchemaSimpleTypeUnion.class, XmlSchemaTotalDigitsFacet.class,
				XmlSchemaType.class, XmlSchemaUnique.class, XmlSchemaUse.class, XmlSchemaWhiteSpaceFacet.class,
				XmlSchemaXPath.class, XmlSeverityType.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { CollectionFactory.class, DOMUtil.class,
				NamespaceContextOwner.class, NamespaceMap.class, NamespacePrefixList.class, NodeNamespaceContext.class,
				PrefixCollector.class, TargetNamespaceValidator.class, UtilObjects.class, XDOMUtil.class,
				XmlSchemaNamed.class, XmlSchemaNamedImpl.class, XmlSchemaNamedWithForm.class,
				XmlSchemaNamedWithFormImpl.class, XmlSchemaObjectBase.class, XmlSchemaRef.class,
				XmlSchemaRefBase.class }));

		classes.addAll(Arrays
				.asList(new Class<?>[] { CollectionURIResolver.class, DefaultURIResolver.class, URIResolver.class }));

		classes.addAll(
				Arrays.asList(new Class<?>[] { DefaultExtensionDeserializer.class, DefaultExtensionSerializer.class,
						ExtensionDeserializer.class, ExtensionRegistry.class, ExtensionSerializer.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { Constants.class }));

		summary(classes.toArray(new Class<?>[] {}));

	}
}
