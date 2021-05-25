package com.programacion.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.distribuida.pojos.Autor;

@ApplicationScoped
public class ServicioAutorImpl implements ServicioAutor{

	@Inject
	private DataSource dataSource;
	
	@Override
	public List<Autor> listarAutores() {
		List<Autor> list = new ArrayList<Autor>();
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from autor");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Autor p = new Autor();
				p.setId(rs.getLong(1));
				p.setEdad(rs.getLong(2));
				p.setGenero(rs.getString(3));
				p.setNombre(rs.getString(4));

				list.add(p);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	
	}

	@Override
	public Autor AutorByID(Long id) {
		
		return null;
	}

	@Override
	public Autor crearAutor(Autor autor) {
		
		try {
			
			Connection con = dataSource.getConnection();
			System.out.println("ingreso servicioimpl");
			PreparedStatement ps = con.prepareStatement("insert into autor (edad,genero,nombre)values(?,?,?)");
			//PreparedStatement ps = con.prepareStatement("insert into Persona ( id ,nombre,direccion,correo)values('1726817','Juan','Che','jdquishpee@uce.ed')");

			ps.setLong(1, autor.getId());
			ps.setLong(2, autor.getEdad());
			ps.setString(3,autor.getGenero());
		    ps.setString(2, autor.getNombre());
         
		    
			ps.executeUpdate();
			con.close();
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}

			return autor;
		
	}

	@Override
	public Autor actualizar(Autor autor) {
		
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("update autor set edad=?,genero=?,nombre=? where id=?");
			ps.setLong(1, autor.getId());
			ps.setLong(2, autor.getEdad());
			ps.setString(3,autor.getGenero());
		    ps.setString(2, autor.getNombre());
			ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	
	        return null;			
	}

	@Override
	public Response eliminar(Long id) {
		
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from autor where id=?");
			ps.setLong(1, id);
			ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

			return null;	
		
	}

	
	
	
	
}
