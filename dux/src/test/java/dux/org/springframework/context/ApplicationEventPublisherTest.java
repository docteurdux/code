package dux.org.springframework.context;

import org.springframework.context.ApplicationEventPublisher;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

@Topic(ApplicationEventPublisher.class)
@Prerequisites(ApplicationEventTest.class)
public class ApplicationEventPublisherTest {

}
