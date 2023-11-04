package CadastroUsuarios.requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CadastroUsuarioRequests {
	/**
	 * Request POST cadastro de usuários
	 *
	 * @param payload
	 * @return Response da request
	 */
	public static Response requestCadastroPost(String payload) {
		return RestAssured.given().contentType(ContentType.JSON).body(payload).post();
	}
}