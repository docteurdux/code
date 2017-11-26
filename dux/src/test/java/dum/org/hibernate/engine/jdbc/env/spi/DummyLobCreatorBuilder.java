package dum.org.hibernate.engine.jdbc.env.spi;

import org.hibernate.engine.jdbc.LobCreationContext;
import org.hibernate.engine.jdbc.LobCreator;
import org.hibernate.engine.jdbc.env.spi.LobCreatorBuilder;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyLobCreatorBuilder implements LobCreatorBuilder {

	private RunnableWithArgs<LobCreator> buildLobCreatorRWA;

	@Override
	public LobCreator buildLobCreator(LobCreationContext lobCreationContext) {
		if (buildLobCreatorRWA != null) {
			return buildLobCreatorRWA.run(lobCreationContext);
		}
		return null;
	}

	public void setBuildLobCreatorRWA(RunnableWithArgs<LobCreator> buildLobCreatorRWA) {
		this.buildLobCreatorRWA = buildLobCreatorRWA;
	}

}
