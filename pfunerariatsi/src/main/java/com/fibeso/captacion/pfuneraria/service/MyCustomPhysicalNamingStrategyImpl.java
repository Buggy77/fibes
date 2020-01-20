package com.fibeso.captacion.pfuneraria.service;

import java.io.Serializable;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class MyCustomPhysicalNamingStrategyImpl implements PhysicalNamingStrategy, Serializable{

	public static final MyCustomPhysicalNamingStrategyImpl INSTANCE = new MyCustomPhysicalNamingStrategyImpl();
			
	@Override
	public Identifier toPhysicalCatalogName(final Identifier name, final JdbcEnvironment jdbcEnvironment) {
		// TODO Auto-generated method stub
		return new Identifier(name.getText(), true);
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		// TODO Auto-generated method stub
		return new Identifier(name.getText(), true);
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		// TODO Auto-generated method stub
		return new Identifier(name.getText(), true);
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		// TODO Auto-generated method stub
		return new Identifier(name.getText(), true);
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		// TODO Auto-generated method stub
		return new Identifier(name.getText(), true);
	}

}
