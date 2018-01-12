package com.github.docteurdux.castle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=UTF-8");
		resp.getWriter().println("hello");
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("config/castle.properties");
		Properties props = new Properties();
		props.load(resourceAsStream);
		resp.getWriter().println(props.getProperty("name"));
	}
}
