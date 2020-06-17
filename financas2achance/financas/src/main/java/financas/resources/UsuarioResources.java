package financas.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import financas.model.Usuario;
import financas.model.dao.DAO;

@Path("/usuarios")
public class UsuarioResources implements ResourceInterface<Usuario>{
	
	@GET
	@Produces("application/json")
	@Override
	public Response get() {
		DAO<Usuario> dao = new DAO<>(Usuario.class);
		List<Usuario> usuarios = dao.listarGenerico("Usuario.listarTodos");

		return Response.ok(usuarios).build();
	}

	@Path("/{id}")
	@GET
	@Produces("application/json")
	@Override
	public Response getById(@PathParam("id") Long id) {
		DAO<Usuario> dao = new DAO<>(Usuario.class);
		Usuario usuario = dao.consultarGenerico("Usuario.consultarPorId", id);
		if (usuario != null) {
			return Response.ok(usuario).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Override
	public Response post(Usuario usuario) {
		DAO<Usuario> dao = new DAO<>(Usuario.class);
		dao.adicionar(usuario);
		return Response.ok(usuario).build();
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	@Override
	public Response put(Usuario usuario) {
		DAO<Usuario> dao = new DAO<>(Usuario.class);
		dao.alterar(usuario);
		return Response.ok(usuario).build();
	}
	
	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	@Override
	public Response delete(@PathParam("id") Long id) {
		DAO<Usuario> dao = new DAO<>(Usuario.class);
		if (dao.excluir(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
}
