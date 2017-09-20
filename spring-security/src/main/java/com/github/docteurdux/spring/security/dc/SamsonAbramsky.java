package com.github.docteurdux.spring.security.dc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.expression.DenyAllPermissionEvaluator;

import com.github.docteurdux.org.springframework.security.core.AuthenticationDUX;
import com.github.docteurdux.spring.security.LogUtils;
import com.github.docteurdux.spring.security.notes.TU;

public class SamsonAbramsky {
	public static void main(String[] args) {

		List<String> messages = new ArrayList<>();
		LogUtils.recordAndDumpLog(messages, DenyAllPermissionEvaluator.class);

		DenyAllPermissionEvaluator da = new DenyAllPermissionEvaluator();

		AuthenticationDUX authentication = new AuthenticationDUX();
		authentication.setName("name");

		Serializable targetId = "targetId";
		Object permission = "permission";
		Object target = "target";

		TU.fal(da.hasPermission(authentication, target, permission));

		TU.fal(da.hasPermission(authentication, targetId, null, permission));

		TU.eq(messages.size(), 2);

		System.out.println("Done.");
	}
}
