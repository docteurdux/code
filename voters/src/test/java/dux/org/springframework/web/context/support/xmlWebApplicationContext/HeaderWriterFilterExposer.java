package dux.org.springframework.web.context.support.xmlWebApplicationContext;

import java.util.List;

import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.HeaderWriterFilter;

import duu.java.lang.reflect.FieldUtils;

public class HeaderWriterFilterExposer {

	private HeaderWriterFilter exposed;

	public HeaderWriterFilterExposer(HeaderWriterFilter exposed) {
		this.exposed = exposed;
	}

	@SuppressWarnings("unchecked")
	public List<HeaderWriter> getHeaderWriters() {
		return (List<HeaderWriter>) FieldUtils.getFieldValue(HeaderWriterFilter.class, "headerWriters", exposed);
	}

}
