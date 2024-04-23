package Services.CadastroProdutos.requests;

import Utils.UtilsUsuario;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class CadastroProdutoRequests {

	static String token = UtilsUsuario.getToken();

	/**
	 * Request POST cadastro de produtos
	 *
	 * @param payload
	 * @return response
	 */
	@Step("Enviando requisição para cadastro de produtos")
	public static ValidatableResponse requestCadastroProdutosPost(String payload) {
		return RestAssured.given()
				.contentType(ContentType.JSON)
				.header("Authorization", token)
				.body(payload)
				.post()
				.then();
	}
}