package dum.org.hibernate.boot.model;

import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import org.hibernate.boot.model.IdGeneratorStrategyInterpreter;
import org.hibernate.boot.model.IdentifierGeneratorDefinition.Builder;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyIdGeneratorStrategyInterpreter extends TestEventCollector implements IdGeneratorStrategyInterpreter {

	private RunnableWithArgs<Void> interpretTableGeneratorRWA;
	private RunnableWithArgs<Void> interpretSequenceGeneratorRWA;

	@Override
	public String determineGeneratorName(GenerationType generationType, GeneratorNameDeterminationContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void interpretTableGenerator(TableGenerator tableGeneratorAnnotation, Builder definitionBuilder) {
		testEvents
				.add(new TestEvent("interpretTableGenerator").prop("tableGeneratorAnnotation", tableGeneratorAnnotation)
						.prop("definitionBuilder", definitionBuilder));
		if (interpretTableGeneratorRWA != null) {
			interpretTableGeneratorRWA.run(tableGeneratorAnnotation, definitionBuilder);
		}
	}

	public void setInterpretTableGeneratorRWA(RunnableWithArgs<Void> interpretTableGeneratorRWA) {
		this.interpretTableGeneratorRWA = interpretTableGeneratorRWA;
	}

	@Override
	public void interpretSequenceGenerator(SequenceGenerator sequenceGeneratorAnnotation, Builder definitionBuilder) {
		testEvents.add(new TestEvent("interpretSequenceGenerator")
				.prop("sequenceGeneratorAnnotation", sequenceGeneratorAnnotation)
				.prop("definitionBuilder", definitionBuilder));
		if (interpretSequenceGeneratorRWA != null) {
			interpretSequenceGeneratorRWA.run(sequenceGeneratorAnnotation, definitionBuilder);
		}
	}

	public void setInterpretSequenceGeneratorRWA(RunnableWithArgs<Void> interpretSequenceGeneratorRWA) {
		this.interpretSequenceGeneratorRWA = interpretSequenceGeneratorRWA;
	}

}
