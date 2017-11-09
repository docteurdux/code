package dux.org.hibernate.query.criteria.internal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.integrator.spi.Integrator;
import org.hibernate.integrator.spi.IntegratorService;

public class DummyIntegratorService implements IntegratorService {

	private static final long serialVersionUID = 1L;
	private List<Integrator> integrators = new ArrayList<>();

	@Override
	public Iterable<Integrator> getIntegrators() {
		return integrators;
	}
	

}
