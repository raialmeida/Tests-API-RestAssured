package services.CadastroUsuarios.tests;

import static io.restassured.RestAssured.basePath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Config.TestConfig;
import services.CadastroUsuarios.payloads.CadastroUsuarioPayloads;
import services.CadastroUsuarios.requests.CadastroUsuarioRequests;

@DisplayName("Testes da rota POST /usuarios")
public class CadastroUsuarioTest extends TestConfig {

	String payload = CadastroUsuarioPayloads.payloadCadastroUsuario();

	@BeforeEach
	public void before() {
		basePath = "/usuarios";
	}

	@Test
	@DisplayName("Validar status code 201")
	public void validarStatusCodeCadastroUsuarios() {
		CadastroUsuarioRequests.requestCadastroPost(payload).then().assertThat().statusCode(201);
	}
}