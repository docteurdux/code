package dum.org.springframework.security.web.csrf;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;

public class DummyCsrfTokenRepository implements CsrfTokenRepository {

	public static enum MethodName {
		SAVE_TOKEN, GENERATE_TOKEN, LOAD_TOKEN
	};

	private CsrfToken token;
	private CsrfToken newToken;
	private Map<MethodName, Integer> counters = new HashMap<>();

	@Override
	public CsrfToken generateToken(HttpServletRequest request) {
		inc(MethodName.GENERATE_TOKEN);
		return newToken;
	}

	public void setNewToken(CsrfToken newToken) {
		this.newToken = newToken;
	}

	@Override
	public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
		inc(MethodName.SAVE_TOKEN);
		this.token = token;
	}

	public CsrfToken getToken() {
		return token;
	}

	public void setToken(CsrfToken token) {
		this.token = token;
	}

	@Override
	public CsrfToken loadToken(HttpServletRequest request) {
		inc(MethodName.LOAD_TOKEN);
		return token;
	}

	private void inc(MethodName name) {
		if (!counters.containsKey(name)) {
			counters.put(name, 0);
		}
		counters.put(name, counters.get(name) + 1);
	}

	public int getCounter(MethodName name) {
		Integer counter = counters.get(name);
		if (counter == null) {
			return 0;
		}
		return counter;
	}

}
