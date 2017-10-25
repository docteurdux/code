package dux.org.apache.cxf.service.model;

import java.lang.reflect.Field;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.DescriptionInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class InterfaceInfoTest extends AbstractTest {

	private QName iiQn;
	private QName iiQn2;
	private QName oiQn;
	private DescriptionInfo description;
	private ServiceInfo si;
	private InterfaceInfo ii;

	@Before
	public void before() {

		iiQn = new QName("iiQn");
		iiQn2 = new QName("iiQn2");
		oiQn = new QName("oiQn");

		description = new DescriptionInfo();

		si = new ServiceInfo();
		si.setDescription(description);

		ii = new InterfaceInfo(si, iiQn);
	}

	/**
	 * The service is not modifiable, but the name is ; the description of the
	 * interface is actually description of the service ; the constructor sets the
	 * interface of the service info
	 **/
	@Test
	public void test1() {

		aeq(si, ii.getService());
		at(iiQn.equals(ii.getName()));
		ii.setName(iiQn2);
		at(iiQn2.equals(ii.getName()));

		aeq(description, ii.getDescription());

		aeq(ii, si.getInterface());
	}

	/** Operations can be added and removed **/
	@Test
	public void test2() {

		an(ii.getOperation(oiQn));
		aeq(0, ii.getOperations().size());

		ii.addOperation(oiQn);
		OperationInfo oi = ii.getOperation(oiQn);
		ann(ii.getOperation(oiQn));

		ii.removeOperation(oi);
		an(ii.getOperation(oiQn));

	}

	/** Adding same operation twice throws **/
	@Test(expected = IllegalArgumentException.class)
	public void test3() {

		ii.addOperation(oiQn);
		ii.addOperation(oiQn);
	}

	/** Adding null operation throws **/
	@Test(expected = NullPointerException.class)
	public void test4() {
		ii.addOperation(null);
	}

	/**
	 * Although it is not possible to set the service to null, getting the
	 * description of a null service does not throw
	 **/
	@Test
	public void test5()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = InterfaceInfo.class.getDeclaredField("service");
		field.setAccessible(true);
		field.set(ii, null);
		an(ii.getDescription());
	}

}
