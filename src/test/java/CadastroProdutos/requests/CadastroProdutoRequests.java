package CadastroProdutos.requests;

import Utils.UtilsUsuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jakarta.json.JsonObject;

public class CadastroProdutoRequests {

	static String token = UtilsUsuario.getToken();

	/**
	 * Request POST cadastro de produtos
	 *
	 * @param payload
	 * @return response
	 */
	public static Response requestCadastroProdutosPost(JsonObject payload) {
		return RestAssured.given().contentType(ContentType.JSON).header("Authorization", token)
				.body(payload).post();
	}
}