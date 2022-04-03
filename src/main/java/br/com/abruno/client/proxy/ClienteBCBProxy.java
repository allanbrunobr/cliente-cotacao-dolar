package br.com.abruno.client.proxy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "bcb-proxy")
@Path("/v1/api/bcb")
public interface ClienteBCBProxy {

	@GET
	@Path("/periodo/{dataFinalCotacao}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	String getPeriodoCotacao(@PathParam("dataFinalCotacao") String dataFinalCotacao);

	@GET
	@Path("/{data}")
	@Produces(MediaType.APPLICATION_JSON)
	String getCotacaoData(@PathParam("data") String data);

}
