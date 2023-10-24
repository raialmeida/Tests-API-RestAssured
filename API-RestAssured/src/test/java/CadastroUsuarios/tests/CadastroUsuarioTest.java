package CadastroUsuarios.tests;

import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import CadastroUsuarios.payloads.CadastroUsuarioPayloads;
import CadastroUsuarios.requests.CadastroUsuarioRequests;
import Config.TestConfig;

@DisplayName("Testes da rota POST /usuarios")
public class CadastroUsuarioTest extends TestConfig {

	@BeforeEach
	public void before() {
		basePath = "/usuarios";
	}

	@Test
	@DisplayName("Validar status code da rota POST cadstro de usuários")
	public void validarStatusCodeCadastroUsuarios() {
		String payload = CadastroUsuarioPayloads.payload();
		CadastroUsuarioRequests.RequestCadastroPost(payload).then().log().all().assertThat().statusCode(201);
	}
}