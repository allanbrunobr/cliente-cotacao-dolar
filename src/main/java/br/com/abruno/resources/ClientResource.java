package br.com.abruno.resources;

import java.text.ParseException;

import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.abruno.client.exceptions.DataInvalidaException;
import br.com.abruno.client.proxy.ClienteBCBProxy;
import br.com.abruno.client.utils.Utils;

@Path("/v1/api/client")
@Tag(name = "Cotacao Dólar")
public class ClientResource {

	@Inject
	@RestClient
	ClienteBCBProxy clienteBCBProxy;

	@Path("/periodo/{dataFinalCotacao}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@APIResponse(responseCode = "200", description = "Ok")
	@APIResponse(responseCode = "400", description = "Data inválida")
	@Operation(description = "Busca a cotação do dólar no dia informado e a do dia anterior", summary = "Cotações do dólar nos dias informado e anterior")
	public String getPeriodoCotacao(
			@PathParam("dataFinalCotacao") @Schema(description = "Data da cotação", example = "03-04-2021") @NotEmpty(message = "Campo obrigatório") String dataFinalCotacao)
			throws ParseException, DataInvalidaException {
		return clienteBCBProxy.getPeriodoCotacao(Utils.periodoValido(dataFinalCotacao));

	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Operation(description = "Busca a cotação do dólar no dia informado", summary = "Cotação do dólar no dia informado")
	@APIResponse(responseCode = "200", description = "Ok")
	@APIResponse(responseCode = "400", description = "Data inválida")
	@Path("/{data}")
	public String getCotacaoData(@PathParam("data")  @Schema(description="Data da cotação", example="\'03-04-2021\'") @NotEmpty(message = "Campo obrigatório") String data) throws DataInvalidaException, ParseException {
		return clienteBCBProxy.getCotacaoData(Utils.dataValida(data));
	}
}