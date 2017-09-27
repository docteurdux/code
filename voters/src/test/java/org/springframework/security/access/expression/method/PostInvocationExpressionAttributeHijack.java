package org.springframework.security.access.expression.method;

import org.springframework.security.access.prepost.PostInvocationAttribute;

public class PostInvocationExpressionAttributeHijack {

	public static PostInvocationAttribute get(String filterExpression, String authorizeExpression) {
		return new PostInvocationExpressionAttribute(filterExpression, authorizeExpression);
	}

}
