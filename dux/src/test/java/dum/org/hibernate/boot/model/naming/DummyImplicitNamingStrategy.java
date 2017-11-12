package dum.org.hibernate.boot.model.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitAnyDiscriminatorColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitAnyKeyColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitCollectionTableNameSource;
import org.hibernate.boot.model.naming.ImplicitDiscriminatorColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitEntityNameSource;
import org.hibernate.boot.model.naming.ImplicitForeignKeyNameSource;
import org.hibernate.boot.model.naming.ImplicitIdentifierColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitIndexColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitIndexNameSource;
import org.hibernate.boot.model.naming.ImplicitJoinColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitJoinTableNameSource;
import org.hibernate.boot.model.naming.ImplicitMapKeyColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitPrimaryKeyJoinColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitTenantIdColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitUniqueKeyNameSource;

import com.github.docteurdux.test.hibernate.BasicColumnNameDeterminer;

public class DummyImplicitNamingStrategy implements ImplicitNamingStrategy {

	private BasicColumnNameDeterminer basicColumnNameDeterminer;

	@Override
	public Identifier determinePrimaryTableName(ImplicitEntityNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineJoinTableName(ImplicitJoinTableNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineCollectionTableName(ImplicitCollectionTableNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineDiscriminatorColumnName(ImplicitDiscriminatorColumnNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineTenantIdColumnName(ImplicitTenantIdColumnNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineIdentifierColumnName(ImplicitIdentifierColumnNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource source) {
		if (basicColumnNameDeterminer != null) {
			return basicColumnNameDeterminer.determineBasicColumnName(source);
		}
		return null;
	}

	public void setBasicColumnNameDeterminer(BasicColumnNameDeterminer basicColumnNameDeterminer) {
		this.basicColumnNameDeterminer = basicColumnNameDeterminer;
	}

	@Override
	public Identifier determineJoinColumnName(ImplicitJoinColumnNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determinePrimaryKeyJoinColumnName(ImplicitPrimaryKeyJoinColumnNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineAnyDiscriminatorColumnName(ImplicitAnyDiscriminatorColumnNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineAnyKeyColumnName(ImplicitAnyKeyColumnNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineMapKeyColumnName(ImplicitMapKeyColumnNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineListIndexColumnName(ImplicitIndexColumnNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineForeignKeyName(ImplicitForeignKeyNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineUniqueKeyName(ImplicitUniqueKeyNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier determineIndexName(ImplicitIndexNameSource source) {
		// TODO Auto-generated method stub
		return null;
	}

}
