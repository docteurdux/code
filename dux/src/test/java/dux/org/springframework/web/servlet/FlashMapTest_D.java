package dux.org.springframework.web.servlet;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.FlashMap;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.Topic;

@Done
@Topic(FlashMap.class)
public class FlashMapTest_D extends AbstractTest {
	@Test
	public void test() {

		/*
		 * A org.springframework.web.servlet.FlashMap is a map which has a possible
		 * expiration time and an additional multi value map which can receive request
		 * parameters
		 */

		FlashMap m = new FlashMap();

		/* Default expiration time is -1, which means "no expiration time" */
		aeq(-1L, m.getExpirationTime());
		aeq(false, m.isExpired());

		/* 0 expiration time there means always expired */
		m.setExpirationTime(0);
		aeq(0L, m.getExpirationTime());
		aeq(true, m.isExpired());

		/* expiration time set to 1 second in the future => not expired */
		m.setExpirationTime(System.currentTimeMillis() + 1000);
		aeq(false, m.isExpired());

		/* startExpirationPeriod sets the expiration time in seconds from now */
		m.startExpirationPeriod(10);
		long now = System.currentTimeMillis();
		aeq(now + 10 * 1000, m.getExpirationTime());

		/* There's also a target request path */

		aeq(null, m.getTargetRequestPath());
		m.setTargetRequestPath("path");
		aeq("path", m.getTargetRequestPath());

		/* And the target request params, which can be set in two different ways */

		aeq(0, m.getTargetRequestParams().size());

		/* One specific parameter */
		m.addTargetRequestParam("name", "value");
		aeq(1, m.getTargetRequestParams().size());

		/* A multi value map of parameters */
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("name1", "value1");
		params.add("name2", "value2");
		m.addTargetRequestParams(params);
		aeq(3, m.getTargetRequestParams().size());

		/* Empty (and null) names and values are ignored */
		m.addTargetRequestParam("name3", "");
		aeq(3, m.getTargetRequestParams().size());

		m.addTargetRequestParam("", "value4");
		aeq(3, m.getTargetRequestParams().size());

		/* FlashMap implements java.lang.Comparable */

		FlashMap m1 = new FlashMap();
		FlashMap m2 = new FlashMap();

		aeq(0, m1.compareTo(m2));

		/* But it's unusual, it first compares whether the paths are there are not */

		m1.setTargetRequestPath("path");
		aeq(-1, m1.compareTo(m2));
		m1.setTargetRequestPath(null);

		m2.setTargetRequestPath("path");
		aeq(1, m1.compareTo(m2));
		m2.setTargetRequestPath(null);

		/*
		 * But if the target request paths are both set, it only compares the size of
		 * the target request params
		 */

		m1.setTargetRequestPath("path1");
		m2.setTargetRequestPath("path2");
		aeq(0, m1.compareTo(m2));

		m1.addTargetRequestParam("name", "value");
		aeq(-1, m1.compareTo(m2));

		/* toString does something */

		aeq("FlashMap [attributes={}, targetRequestPath=path, targetRequestParams={name=[value], name1=[value1], name2=[value2]}]",
				m.toString());

		/* equality and hashcode are as one could expect */

	}
}
