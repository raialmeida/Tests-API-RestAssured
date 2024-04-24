package Utils;

import Services.CadastroUsuarios.payloads.CadastroUsuarioPayloads;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UtilsUsuario {

	static String userPayload = CadastroUsuarioPayloads.payloadCadastroUsuario(
			"Fulano da Silva",
			"rateste@qa.com.br",
			"teste");

	static String usuario = "{\r\n" + "  \"email\": \"rateste@qa.com.br\",\r\n" + "  \"password\": \"teste\"\r\n" + "}";

	/**
	 * Retorna o token do usuário
	 *
	 * @return token
	 */
	@Step("Enviando requisição para obter o token do usuário")
	public static String getToken() {
		return RestAssured.given()
				.contentType(ContentType.JSON)
				.body(usuario)
				.basePath("/login")
				.post()
				.jsonPath().getString("authorization");
	}

	@Step("Cadastro o usuário antes dos testes para obter token")
	public static void cadastrarUsuario() {
		RestAssured.given()
				.contentType(ContentType.JSON)
				.body(userPayload)
				.basePath("/usuarios")
				.post();
	}
}