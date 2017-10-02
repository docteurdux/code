package duu.org.springframework.security.web.authentication.logout;

import java.util.List;

import org.springframework.security.web.authentication.logout.CompositeLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import duu.Exposer;

public class CompositeLogoutHandlerExposer implements Exposer<CompositeLogoutHandler> {

	private CompositeLogoutHandler exposed;

	public CompositeLogoutHandlerExposer(CompositeLogoutHandler exposed) {
		this.exposed = exposed;
	}

	public List<LogoutHandler> getLogoutHandlers() {
		return CompositeLogoutHandlerUtils.getLogoutHandlers(exposed);
	}

	@Override
	public CompositeLogoutHandler getExposed() {
		return exposed;
	}

}
