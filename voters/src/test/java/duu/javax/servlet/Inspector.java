package duu.javax.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface Inspector {

	void inspect(ServletRequest request, ServletResponse response) throws IOException, ServletException;

}
