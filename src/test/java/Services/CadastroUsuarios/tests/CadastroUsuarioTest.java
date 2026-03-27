package Services.CadastroUsuarios.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Config.TestConfig;
import Services.CadastroUsuarios.payloads.CadastroUsuarioPayloads;
import Services.CadastroUsuarios.requests.CadastroUsuarioRequests;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;

@DisplayName("Testes da rota POST /usuarios")
@Feature("Cadastro de Usuarios")
public class CadastroUsuarioTest extends TestConfig {

	String payload = CadastroUsuarioPayloads.payloadCadastroUsuario();

	@Test
	@DisplayName("Validar status code 201")
	@Issue("9799")
	public void validarStatusCodeCadastroUsuarios() {
		CadastroUsuarioRequests.requestCadastroUsuarioPost(payload)
				.assertThat()
				.statusCode(201);
	}
}