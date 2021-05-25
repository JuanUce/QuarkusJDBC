package com.programacion.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.distribuida.pojos.Autor;
import com.programacion.servicios.ServicioAutor;

@Path("/autores")
@ApplicationScoped
public class AutorRest {

	@Inject
	ServicioAutor servicio;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Autor> listAutores() {
		return servicio.listarAutores();
	}

	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Autor autorByID(@PathParam("id") Long id) {

		return servicio.AutorByID(id);
	}

	@POST
	@Transactional
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Autor createAutor(Autor autor) {
		
		return servicio.crearAutor(autor);

	}

	@PUT
	@Transactional
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	public Autor update(Autor autor) {


		return servicio.actualizar(autor);
	}

	@DELETE
	@Transactional
	@Path("/eliminar/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response eliminar(@PathParam("id") Long id) {
		
		return servicio.eliminar(id);

	}

}
