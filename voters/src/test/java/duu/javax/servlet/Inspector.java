package duu.javax.servlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface Inspector {

	void inspect(ServletRequest request, ServletResponse response);

}
