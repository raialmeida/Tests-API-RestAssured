package CadastroProdutos.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import CadastroProdutos.payloads.CadastroProdutoPayloads;
import CadastroProdutos.requests.CadastroProdutoRequests;
import Config.TestConfig;

@DisplayName("Testes da rota POST /produtos")
public class CadastroProdutosTest extends TestConfig {

	@BeforeEach
	public void before() {
		basePath = "/produtos";
	}

	@Test
	@Tag("usuario")
	@DisplayName("Validar cadastro com sucesso")
	public void validarCadastroProduto() {
		String payload = CadastroProdutoPayloads.payload();
		CadastroProdutoRequests.RequestCadastroProdutosPost(payload).then().log().all().assertThat().body("message",
				equalTo("Cadastro realizado com sucesso"));
	}

	@Test
	@DisplayName("Validar status code 201")
	public void validarStatusCodeCadastroProduto() {
		String payload = CadastroProdutoPayloads.payload();
		CadastroProdutoRequests.RequestCadastroProdutosPost(payload).then().log().all().assertThat().statusCode(201);
	}
}
