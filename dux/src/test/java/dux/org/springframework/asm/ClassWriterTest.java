package dux.org.springframework.asm;

import java.lang.management.BufferPoolMXBean;

import org.junit.Test;
import org.springframework.asm.Attribute;
import org.springframework.asm.ClassWriter;
import org.springframework.asm.Handle;
import org.springframework.asm.TypePath;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.Topic;

@Topic(ClassWriter.class)
public class ClassWriterTest extends AbstractTest {

	String value;
	Object cst;
	String owner;
	String name;
	String desc;
	int tag;
	boolean itf;
	Handle bsm;
	Object bsmArgs;
	String methodDesc;
	String moduleName;
	String packageName;
	int version;
	int access;
	String signature;
	String superName;
	String[] interfaces;
	boolean visible;
	Attribute attr;
	String outerName;
	String innerName;
	String name2;
	int access2;
	String version2;
	String[] exceptions;
	String file;
	String debug;
	int typeRef;
	TypePath typePath;

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws JsonProcessingException {

		ClassWriter cw = new ClassWriter(0);

		aeq(2, cw.newClass("name"));
		byte[] bytes = cw.toByteArray();

		baeq(bytes, 0xCA, 0xFE, 0xBA, 0xBE); // magic
		baeq(bytes, 0x00, 0x00, 0x00, 0x00); // version
		baeq(bytes, 0x00, 0x03); // index
		baeq(bytes, 0x01); // Announce UTF8 constant
		baeq(bytes, 0x0, 0x4); // Length of the string
		baeq(bytes, "name".getBytes()); // Actual string
		baeq(bytes, 0x7, 0x0, 0x1); // Class definition
		baeq(bytes, 0x0, 0x0); // Mask
		baeq(bytes, 0x0, 0x0); // Name
		baeq(bytes, 0x0, 0x0); // Super name
		baeq(bytes, 0x0, 0x0); // Interface count
		baeq(bytes, 0x0, 0x0); // Number of fields
		baeq(bytes, 0x0, 0x0); // Number of methods
		baeq(bytes, 0x0, 0x0); // Number of attributes
		baeqEnd(bytes);

		cw = new ClassWriter(0);
		cw.newConst(1);
		bytes = cw.toByteArray();
		baeqOffset(0);
		baeq(bytes, 0xCA, 0xFE, 0xBA, 0xBE); // magic
		baeq(bytes, 0x00, 0x00, 0x00, 0x00); // version
		baeq(bytes, 0x00, 0x02); // index
		baeq(bytes, 0x03); // Announce an integer
		baeq(bytes, 0x00, 0x00, 0x00, 0x01); // actual value
		baeq(bytes, 0x0, 0x0); // Mask
		baeq(bytes, 0x0, 0x0); // Name
		baeq(bytes, 0x0, 0x0); // Super name
		baeq(bytes, 0x0, 0x0); // Interface count
		baeq(bytes, 0x0, 0x0); // Number of fields
		baeq(bytes, 0x0, 0x0); // Number of methods
		baeq(bytes, 0x0, 0x0); // Number of attributes
		baeqEnd(bytes);

		cw = new ClassWriter(0);
		cw.newField("o", "n", "d");
		bytes = cw.toByteArray();
		baeqOffset(0);
		baeq(bytes, //
				0xCA, 0xFE, 0xBA, 0xBE, // magic
				0x00, 0x00, 0x00, 0x00, // version
				0x00, 0x07, // index
				0x01, 0x00, 0x01, 0x6F, // UTF8 constant "o"
				0x07, 0x00, 0x01, // Class o
				0x01, 0x00, 0x01, 0x6E, // UTF8 constant "n"
				0x01, 0x00, 0x01, 0x64, // UTF8 constant "d"
				0x0C, 0x00, 0x03, 0x00, 0x04, // Named type "n", "d"
				0x09, 0x00, 0x02, 0x00, 0x05, // Field "o", "n", "d"
				0x0, 0x0, // Mask
				0x0, 0x0, // Name
				0x0, 0x0, // Super name
				0x0, 0x0, // Interface count
				0x0, 0x0, // Number of fields
				0x0, 0x0, // Number of methods
				0x0, 0x0 // Number of attributes
		);
		 baeqEnd(bytes);

		 
		// cw.newClass(value);
		// cw.newConst(cst);
		// cw.newField(owner, name, desc);
		// cw.newHandle(tag, owner, name, desc);
		// cw.newHandle(tag, owner, name, desc, itf);
		// cw.newInvokeDynamic(name, desc, bsm, bsmArgs);
		// cw.newMethod(owner, name, desc, itf);
		// cw.newMethodType(methodDesc);
		// cw.newModule(moduleName);
		// cw.newNameType(name, desc);
		// cw.newPackage(packageName);
		// cw.newUTF8(value);
		// cw.toByteArray();
		// cw.visit(version, access, name, signature, superName, interfaces);
		// cw.visitAnnotation(desc, visible);
		// cw.visitAttribute(attr);
		// cw.visitEnd();
		// cw.visitField(access, name, desc, signature, value);
		// cw.visitInnerClass(name, outerName, innerName, access);
		// cw.visitMethod(access, name, desc, signature, exceptions);
		// cw.visitModule(name2, access2, version2);
		// cw.visitOuterClass(owner, name, desc);
		// cw.visitSource(file, debug);
		// cw.visitTypeAnnotation(typeRef, typePath, desc, visible);
	}

}
