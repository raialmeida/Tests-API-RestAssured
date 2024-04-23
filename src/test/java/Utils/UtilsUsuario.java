package Utils;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UtilsUsuario {

	static String usuario = "{\r\n" + "  \"email\": \"rateste@qa.com.br\",\r\n" + "  \"password\": \"teste\"\r\n" + "}";

	static String payloadUsuario = "{\r\n" + "  \"nome\": \"Fulano da Silva\",\r\n"
			+ "  \"email\": \"rateste@qa.com.br\",\r\n" + "  \"password\": \"teste\",\r\n"
			+ "  \"administrador\": \"true\"\r\n" + "}";

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
				.body(payloadUsuario)
				.basePath("/usuarios")
				.post();

	}
}