package ControladorDB;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

@ApplicationScoped
public class ControladorDB {

	@Produces @ApplicationScoped
	public DataSource db() { 
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://127.0.0.1:5432/BDAutorLibro");
		ds.setUsername("postgres");
		ds.setPassword("1234");
		return ds;	
	}
}
