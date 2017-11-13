package dux.org.hibernate.cfg.annotations;

import java.lang.annotation.Annotation;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class OneToManyBuilder {

	private Class targetEntity;
	private boolean orphanRemoval;
	private String mappedBy;
	private FetchType fetch;
	private CascadeType[] cascade;

	public OneToManyBuilder targetEntity(Class targetEntity) {
		this.targetEntity = targetEntity;
		return this;
	}

	public OneToManyBuilder orphanRemoval(boolean orphanRemoval) {
		this.orphanRemoval = orphanRemoval;
		return this;
	}

	public OneToManyBuilder mappedBy(String mappedBy) {
		this.mappedBy = mappedBy;
		return this;
	}

	public OneToManyBuilder fetch(FetchType fetch) {
		this.fetch = fetch;
		return this;
	}

	public OneToManyBuilder cascade(CascadeType[] cascade) {
		this.cascade = cascade;
		return this;
	}

	public OneToMany build() {
		return new OneToMany() {

			@Override
			public Class<? extends Annotation> annotationType() {
				return OneToMany.class;
			}

			@Override
			public Class targetEntity() {
				return targetEntity;
			}

			@Override
			public boolean orphanRemoval() {
				return orphanRemoval;
			}

			@Override
			public String mappedBy() {
				return mappedBy;
			}

			@Override
			public FetchType fetch() {
				return fetch;
			}

			@Override
			public CascadeType[] cascade() {
				return cascade;
			}
		};
	}
}
