package dux.org.apache.ws.commons.schema.constants;

import java.lang.reflect.Field;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.constants.Constants;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ConstantsTest extends AbstractTest {
	@Test
	public void test1() {
		aeq("", Constants.DEFAULT_NS_PREFIX);
		aeq("", Constants.NULL_NS_URI);
		aeq("http://www.w3.org/2001/XMLSchema", Constants.URI_2001_SCHEMA_XSD);
		aeq("http://www.w3.org/2001/XMLSchema-instance", Constants.URI_2001_SCHEMA_XSI);
		aeq("xml", Constants.XML_NS_PREFIX);
		aeq("http://www.w3.org/XML/1998/namespace", Constants.XML_NS_URI);
		aeq("xmlns", Constants.XMLNS_ATTRIBUTE);
		aeq("http://www.w3.org/2000/xmlns/", Constants.XMLNS_ATTRIBUTE_NS_URI);
		aeq("xml", Constants.XMLNS_PREFIX);
		aeq("http://www.w3.org/XML/1998/namespace", Constants.XMLNS_URI);
		aeq("any", Constants.XSD_ANY.getLocalPart());
		aeq("anySimpleType", Constants.XSD_ANYSIMPLETYPE.getLocalPart());
		aeq("anyType", Constants.XSD_ANYTYPE.getLocalPart());
		aeq("anyURI", Constants.XSD_ANYURI.getLocalPart());
		aeq("base64Binary", Constants.XSD_BASE64.getLocalPart());
		aeq("boolean", Constants.XSD_BOOLEAN.getLocalPart());
		aeq("byte", Constants.XSD_BYTE.getLocalPart());
		aeq("date", Constants.XSD_DATE.getLocalPart());
		aeq("dateTime", Constants.XSD_DATETIME.getLocalPart());
		aeq("gDay", Constants.XSD_DAY.getLocalPart());
		aeq("decimal", Constants.XSD_DECIMAL.getLocalPart());
		aeq("double", Constants.XSD_DOUBLE.getLocalPart());
		aeq("duration", Constants.XSD_DURATION.getLocalPart());
		aeq("ENTITIES", Constants.XSD_ENTITIES.getLocalPart());
		aeq("ENTITY", Constants.XSD_ENTITY.getLocalPart());
		aeq("float", Constants.XSD_FLOAT.getLocalPart());
		aeq("hexBinary", Constants.XSD_HEXBIN.getLocalPart());
		aeq("ID", Constants.XSD_ID.getLocalPart());
		aeq("IDREF", Constants.XSD_IDREF.getLocalPart());
		aeq("IDREFS", Constants.XSD_IDREFS.getLocalPart());
		aeq("int", Constants.XSD_INT.getLocalPart());
		aeq("integer", Constants.XSD_INTEGER.getLocalPart());
		aeq("language", Constants.XSD_LANGUAGE.getLocalPart());
		aeq("long", Constants.XSD_LONG.getLocalPart());
		aeq("gMonth", Constants.XSD_MONTH.getLocalPart());
		aeq("gMonthDay", Constants.XSD_MONTHDAY.getLocalPart());
		aeq("Name", Constants.XSD_NAME.getLocalPart());
		aeq("NCName", Constants.XSD_NCNAME.getLocalPart());
		aeq("negativeInteger", Constants.XSD_NEGATIVEINTEGER.getLocalPart());
		aeq("NMTOKEN", Constants.XSD_NMTOKEN.getLocalPart());
		aeq("NMTOKENS", Constants.XSD_NMTOKENS.getLocalPart());
		aeq("nonNegativeInteger", Constants.XSD_NONNEGATIVEINTEGER.getLocalPart());
		aeq("nonPositiveInteger", Constants.XSD_NONPOSITIVEINTEGER.getLocalPart());
		aeq("normalizedString", Constants.XSD_NORMALIZEDSTRING.getLocalPart());
		aeq("NOTATION", Constants.XSD_NOTATION.getLocalPart());
		aeq("positiveInteger", Constants.XSD_POSITIVEINTEGER.getLocalPart());
		aeq("QName", Constants.XSD_QNAME.getLocalPart());
		aeq("schema", Constants.XSD_SCHEMA.getLocalPart());
		aeq("short", Constants.XSD_SHORT.getLocalPart());
		aeq("string", Constants.XSD_STRING.getLocalPart());
		aeq("time", Constants.XSD_TIME.getLocalPart());
		aeq("token", Constants.XSD_TOKEN.getLocalPart());
		aeq("unsignedByte", Constants.XSD_UNSIGNEDBYTE.getLocalPart());
		aeq("unsignedInt", Constants.XSD_UNSIGNEDINT.getLocalPart());
		aeq("unsignedLong", Constants.XSD_UNSIGNEDLONG.getLocalPart());
		aeq("unsignedShort", Constants.XSD_UNSIGNEDSHORT.getLocalPart());
		aeq("gYear", Constants.XSD_YEAR.getLocalPart());
		aeq("gYearMonth", Constants.XSD_YEARMONTH.getLocalPart());

	}

	@Test
	public void test2() throws IllegalArgumentException, IllegalAccessException {
		for (Field field : Constants.class.getFields()) {
			if (field.getName().startsWith("XSD_") && field.getType() == QName.class) {
				QName qname = (QName) field.get(null);
				aeq(Constants.URI_2001_SCHEMA_XSD, qname.getNamespaceURI());
			}
		}
	}
}
