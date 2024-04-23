package Services.CadastroUsuarios.requests;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class CadastroUsuarioRequests {
	/**
	 * Request POST cadastro de usuários
	 *
	 * @param payload
	 * @return Response da request
	 */
	@Step("Enviando requisição para cadastro de usuários")
	public static ValidatableResponse requestCadastroUsuarioPost(String payload) {
		return RestAssured.given()
				.contentType(ContentType.JSON)
				.body(payload)
				.post()
				.then();
	}
}