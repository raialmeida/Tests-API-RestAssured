package Services.CadastroUsuarios.requests;

import Config.requestBase;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class CadastroUsuarioRequests extends requestBase {
	/**
	 * Request POST cadastro de usuários
	 *
	 * @param payload
	 * @return Response da request
	 */
	@Step("Enviando requisição para cadastro de usuários")
	public static ValidatableResponse requestCadastroUsuarioPost(String payload) {
		return RestAssured.given().spec(reqSpec)
				.contentType(ContentType.JSON)
				.body(payload)
				.post("/usuarios")
				.then();
	}
}