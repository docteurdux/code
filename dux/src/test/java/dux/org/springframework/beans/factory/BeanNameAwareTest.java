package dux.org.springframework.beans.factory;

import org.springframework.beans.factory.BeanNameAware;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

@Topic(BeanNameAware.class)
@Prerequisites(AwareTest.class)
public class BeanNameAwareTest {

}
