package dux.org.springframework.expression.spel.standard;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(SpelExpressionParser.class)
public class SpelExpressionParserTest extends AbstractTest {

	public static class A {

		public String foo = "foo";

		public String getFoo() {
			return foo;
		}

		public void setFoo(String foo) {
			this.foo = foo;
		}

	}

	@Before
	public void before() {
		requireAllSourcesBut("spring-expression-4.3.9");
	}

	@Test
	public void test() {
		SpelParserConfiguration configuration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, null);
		SpelExpressionParser parser = new SpelExpressionParser(configuration);

		ParserContext context = null;

		Expression ex = parser.parseExpression("true&&false");
		aeq(false, ex.getValue());

		// ex = parser.parseExpression("{1,2,3}.size()");
		// aeq(3, ex.getValue());

		// ex = parser.parseExpression("#foo");
		// aeq(null, ex.getValue());

		ex = parser.parseExpression("{\"a\",\"bb\",\"ccc\"}.![length()][2]");
		aeq(3, ex.getValue());
		ex = parser.parseExpression("{\"a\",\"bb\",\"ccc\"}.?[length()>1][0]");
		aeq("bb", ex.getValue());
		ex = parser.parseExpression("{\"a\",\"bb\",\"ccc\"}.^[length()>1]");
		aeq("bb", ex.getValue());
		ex = parser.parseExpression("{\"a\",\"bb\",\"ccc\"}.$[length()>1]");
		aeq("ccc", ex.getValue());

		ex = parser.parseExpression("#root.foo");
		A a = new A();
		aeq("foo", ex.getValue(a));

		ex = parser.parseExpression("foo=\"bar\"");
		ex.getValue(a);
		aeq("bar", a.getFoo());
		
		ex = parser.parseExpression("1?:2");
		aeq(1, ex.getValue(a));
		
		ex = parser.parseExpression("true?1:2");
		aeq(1, ex.getValue(a));
		
		ex = parser.parseExpression("true||false");
		aeq(true, ex.getValue(a));
		
		ex = parser.parseExpression("true or false");
		aeq(true, ex.getValue(a));
		
		ex = parser.parseExpression("true&&false");
		aeq(false, ex.getValue(a));
		
		ex = parser.parseExpression("true and false");
		aeq(false, ex.getValue(a));
		
		ex = parser.parseExpression("1<2");
		aeq(true, ex.getValue(a));
		
		ex = parser.parseExpression("1<=2");
		aeq(true, ex.getValue(a));
		
		ex = parser.parseExpression("2>1");
		aeq(true, ex.getValue(a));
		
		ex = parser.parseExpression("2>=1");
		aeq(true, ex.getValue(a));
		
		ex = parser.parseExpression("2==2");
		aeq(true, ex.getValue(a));
		
		ex = parser.parseExpression("2!=1");
		aeq(true, ex.getValue(a));
		
		ex = parser.parseExpression("\"a\" instanceof T(java.lang.String)");
		aeq(true, ex.getValue(a));
		
		ex = parser.parseExpression("\"a\" matches '^a$'");
		aeq(true, ex.getValue(a));
		
		ex = parser.parseExpression("2 between {1,3}");
		aeq(true, ex.getValue(a));
		
		ex = parser.parseExpression("1+2");
		aeq(3, ex.getValue(a));
		
		ex = parser.parseExpression("2-1");
		aeq(1, ex.getValue(a));
		
		ex = parser.parseExpression("+2");
		aeq(2, ex.getValue(a));
		
		ex = parser.parseExpression("1*2");
		aeq(2, ex.getValue(a));
		
		ex = parser.parseExpression("4/2");
		aeq(2, ex.getValue(a));
		
		ex = parser.parseExpression("2%4");
		aeq(2, ex.getValue(a));
		
		ex = parser.parseExpression("2^1");
		aeq(2, ex.getValue(a));
		
		ex = parser.parseExpression("2^1");
		aeq(2, ex.getValue(a));
		
		ex = parser.parseExpression("!true");
		aeq(false, ex.getValue(a));
		
		ex = parser.parseExpression("(2)");
		aeq(2, ex.getValue(a));
		
		ex = parser.parseExpression("null");
		aeq(null, ex.getValue(a));
		
		ex = parser.parseExpression("new String(\"a\")");
		aeq("a", ex.getValue(a));
		
		ex = parser.parseExpression("{a:2}[a]");
		aeq(2, ex.getValue(a));

		// ex = parser.parseExpression("f=x->(x+1),f(1)");
		// aeq(2, ex.getValue());
	}
}
