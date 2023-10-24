package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TokenUsuario {

	static String usuario = "{\r\n" + "  \"email\": \"fulano@qa.com\",\r\n" + "  \"password\": \"teste\"\r\n" + "}";

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
}