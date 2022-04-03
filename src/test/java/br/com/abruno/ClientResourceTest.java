package br.com.abruno;

import br.com.abruno.resources.ClientResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(ClientResource.class)
public class ClientResourceTest {

}