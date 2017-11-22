package dum.javax.persistence.criteria;

import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.persistence.metamodel.EntityType;

import org.hibernate.query.criteria.internal.compile.CompilableCriteria;
import org.hibernate.query.criteria.internal.compile.CriteriaInterpretation;
import org.hibernate.query.criteria.internal.compile.RenderingContext;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyCriteriaDelete<T> implements CriteriaDelete<T>, CompilableCriteria {

	private RunnableWithArgs<CriteriaInterpretation> interpretRWA;

	@Override
	public <U> Subquery<U> subquery(Class<U> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Predicate getRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Root<T> from(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Root<T> from(EntityType<T> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Root<T> getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CriteriaDelete<T> where(Expression<Boolean> restriction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CriteriaDelete<T> where(Predicate... restrictions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	@Override
	public CriteriaInterpretation interpret(RenderingContext renderingContext) {
		if (interpretRWA != null) {
			return interpretRWA.run(renderingContext);
		}
		return null;
	}

	public void setInterpretRWA(RunnableWithArgs<CriteriaInterpretation> interpretRWA) {
		this.interpretRWA = interpretRWA;
	}

}
