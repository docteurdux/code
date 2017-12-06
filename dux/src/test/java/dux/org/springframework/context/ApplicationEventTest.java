package dux.org.springframework.context;

import org.springframework.context.ApplicationEvent;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.java.util.EventObjectTest;

@Topic(ApplicationEvent.class)
@Prerequisites(EventObjectTest.class)
public class ApplicationEventTest {

}
