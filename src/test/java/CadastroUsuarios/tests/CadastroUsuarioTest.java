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
	@DisplayName("Validar status code 201")
	public void validarStatusCodeCadastroUsuarios() {
		String payload = CadastroUsuarioPayloads.payload();
		CadastroUsuarioRequests.requestCadastroPost(payload).then().assertThat().statusCode(201);
	}
}