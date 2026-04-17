package Utils;

import Config.RequestBase;
import Services.CadastroUsuarios.payloads.CadastroUsuarioPayloads;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jakarta.json.Json;

public class UtilsUsuario {

	static String userPayload = CadastroUsuarioPayloads.payloadCadastroUsuario(
			"Fulano da Silva",
			"rateste@qa.com.br",
			"teste");

	static String usuario = Json.createObjectBuilder()
			.add("email", "rateste@qa.com.br")
			.add("password", "teste")
			.build().toString();

	/**
	 * Retorna o token do usuário
	 *
	 * @return token
	 */
	@Step("Enviando requisição para obter o token do usuário")
	public static String getToken() {
		return RestAssured.given().spec(RequestBase.reqSpec)
				.contentType(ContentType.JSON)
				.body(usuario)
				.basePath("/login")
				.post()
				.jsonPath().getString("authorization");
	}

	@Step("Cadastro o usuário antes dos testes para obter token")
	public static Response cadastrarUsuario() {
		return RestAssured.given().spec(RequestBase.reqSpec)
				.contentType(ContentType.JSON)
				.body(userPayload)
				.basePath("/usuarios")
				.post();
	}
}