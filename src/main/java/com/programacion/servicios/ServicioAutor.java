package com.programacion.servicios;

import java.util.List;
import javax.ws.rs.core.Response;
import com.distribuida.pojos.Autor;

public interface ServicioAutor {
	
	public List<Autor> listarAutores();
	
	public Autor AutorByID(Long id);
	
	public Autor crearAutor(Autor autor);
	
	public Autor actualizar(Autor autor);
	
	public Response eliminar(Long id);
	
	
	
}
