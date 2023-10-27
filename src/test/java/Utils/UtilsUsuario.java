package Utils;

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
	public static String getToken() {
		String token = RestAssured.given().contentType(ContentType.JSON).body(usuario).basePath("/login").post()
				.jsonPath().getString("authorization");
		return token;
	}

	/**
	 * Cadastro o usuário antes dos testes porque precisa do token
	 */
	public static void cadastrarUsuario() {
		RestAssured.given().contentType(ContentType.JSON).body(payloadUsuario).basePath("/usuarios").post();

	}
}