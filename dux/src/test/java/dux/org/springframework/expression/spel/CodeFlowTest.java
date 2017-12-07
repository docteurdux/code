package dux.org.springframework.expression.spel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.asm.ClassWriter;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;
import org.springframework.expression.spel.CodeFlow.ClinitAdder;
import org.springframework.expression.spel.CodeFlow.FieldAdder;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(CodeFlow.class)
public class CodeFlowTest extends AbstractTest {
	@Test
	@SuppressWarnings("deprecation")
	public void test() {
		ClassWriter classWriter = new ClassWriter(0);
		CodeFlow cf = new CodeFlow("classname", classWriter);

		cf.enterCompilationScope();
		cf.exitCompilationScope();
		cf.finish();
		cf.getClassname();
		cf.lastDescriptor();
		MethodVisitor mv = null;
		cf.loadEvaluationContext(mv);
		cf.loadTarget(mv);
		cf.nextFieldId();
		cf.nextFreeVariableId();
		String descriptor = null;
		cf.pushDescriptor(descriptor);
		ClinitAdder clinitAdder = null;
		cf.registerNewClinit(clinitAdder);
		FieldAdder fieldAdder = null;
		cf.registerNewField(fieldAdder);
		cf.unboxBooleanIfNecessary(mv);

		String desc1 = null;
		String desc2 = null;
		CodeFlow.areBoxingCompatible(desc1, desc2);
		String arraytype = null;
		CodeFlow.arrayCodeFor(arraytype);
		@SuppressWarnings("rawtypes")
		Constructor ctor = null;
		CodeFlow.createSignatureDescriptor(ctor);
		Method method = null;
		CodeFlow.createSignatureDescriptor(method);
		char targetDescriptor = 0;
		String stackDescriptor = null;
		CodeFlow.insertAnyNecessaryTypeConversionBytecodes(mv, targetDescriptor, stackDescriptor);
		String arrayElementType = null;
		CodeFlow.insertArrayStore(mv, arrayElementType);
		String ch = null;
		CodeFlow.insertBoxIfNecessary(mv, ch);
		CodeFlow.insertBoxIfNecessary(mv, descriptor);
		CodeFlow.insertCheckCast(mv, descriptor);
		int size = 0;
		CodeFlow.insertNewArrayCode(mv, size, arraytype);
		CodeFlow.insertNumericUnboxOrPrimitiveTypeCoercion(mv, stackDescriptor, targetDescriptor);
		int value = 0;
		CodeFlow.insertOptimalLoad(mv, value);
		MethodVisitor mv2 = null;
		char ch2 = 0;
		String stackDescriptor2 = null;
		CodeFlow.insertUnboxInsns(mv2, ch2, stackDescriptor2);
		CodeFlow.insertUnboxNumberInsns(mv, targetDescriptor, stackDescriptor);
		CodeFlow.isBooleanCompatible(descriptor);
		Number number = null;
		CodeFlow.isIntegerForNumericOp(number);
		CodeFlow.isPrimitive(descriptor);
		CodeFlow.isPrimitiveArray(descriptor);
		CodeFlow.isPrimitiveOrUnboxableSupportedNumber(descriptor);
		CodeFlow.isPrimitiveOrUnboxableSupportedNumberOrBoolean(descriptor);
		CodeFlow.isReferenceTypeArray(arraytype);
		Class<?> type = null;
		CodeFlow.toDescriptor(type);
		CodeFlow.toDescriptorFromObject(value);
		Class<?>[] types = null;
		CodeFlow.toDescriptors(types);
		Class<?> clazz = null;
		CodeFlow.toJvmDescriptor(clazz);
		CodeFlow.toParamDescriptors(ctor);
		CodeFlow.toParamDescriptors(method);
		CodeFlow.toPrimitiveTargetDesc(descriptor);

	}
}
