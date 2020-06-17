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

import financas.model.Produto;
import financas.model.dao.DAO;

@Path("/produtos")
public class ProdutoResource implements ResourceInterface<Produto>{
	
	@GET
	@Produces("application/json")
	@Override
	public Response get() {
		DAO<Produto> dao = new DAO<>(Produto.class);
		List<Produto> produtos = dao.listarGenerico("Produto.listarTodos");

		return Response.ok(produtos).build();
	}

	@Path("/{id}")
	@GET
	@Produces("application/json")
	@Override
	public Response getById(@PathParam("id") Long id) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		Produto produto = dao.consultarGenerico("Produto.consultarPorId", id);
		if (produto != null) {
			return Response.ok(produto).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Override
	public Response post(Produto produto) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.adicionar(produto);
		return Response.ok(produto).build();
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	@Override
	public Response put(Produto produto) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.alterar(produto);
		return Response.ok(produto).build();
	}
	
	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	@Override
	public Response delete(@PathParam("id") Long id) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		if (dao.excluir(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
		
}
