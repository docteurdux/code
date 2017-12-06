package dux.org.springframework.util;

import org.springframework.util.ResourceUtils;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.java.io.FileTest;
import dux.java.net.URITest;
import dux.java.net.URLConnectionTest;
import dux.java.net.URLTest;

@Topic(ResourceUtils.class)
@Prerequisites({ FileTest.class, URLTest.class, URITest.class, URLConnectionTest.class })
public class ResourceUtilsTest {

}
