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

import financas.model.Produtor;
import financas.model.dao.DAO;

@Path("/produtores")
public class ProdutorResource implements ResourceInterface<Produtor>{
	
	@GET
	@Produces("application/json")
	@Override
	public Response get() {
		DAO<Produtor> dao = new DAO<>(Produtor.class);
		List<Produtor> produtores = dao.listarGenerico("Produtor.listarTodos");
		return Response.ok(produtores).build();
	}

	@Path("/{id}")
	@GET
	@Produces("application/json")
	@Override
	public Response getById(@PathParam("id") Long id) {
		DAO<Produtor> dao = new DAO<>(Produtor.class);
		Produtor produtor = dao.consultarGenerico("Produtor.consultarPorId", id);
		if (produtor != null) {
			return Response.ok(produtor).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Override
	public Response post(Produtor produtor) {
		DAO<Produtor> dao = new DAO<>(Produtor.class);
		dao.adicionar(produtor);
		return Response.ok(produtor).build();
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	@Override
	public Response put(Produtor produtor) {
		DAO<Produtor> dao = new DAO<>(Produtor.class);
		dao.alterar(produtor);
		return Response.ok(produtor).build();
	}
	
	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	@Override
	public Response delete(@PathParam("id") Long id) {
		DAO<Produtor> dao = new DAO<>(Produtor.class);
		if (dao.excluir(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
		
}
