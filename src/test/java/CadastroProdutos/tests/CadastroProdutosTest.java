package CadastroProdutos.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import CadastroProdutos.payloads.CadastroProdutoPayloads;
import CadastroProdutos.requests.CadastroProdutoRequests;
import Config.TestConfig;
import Utils.SchemaValidator;

@DisplayName("Testes da rota POST /produtos")
public class CadastroProdutosTest extends TestConfig {

	@BeforeEach
	public void before() {
		basePath = "/produtos";
	}

	@Test
	@DisplayName("Validar cadastro com sucesso")
	public void validarCadastroProduto() {
		String payload = CadastroProdutoPayloads.payload();
		CadastroProdutoRequests.requestCadastroProdutosPost(payload).then().log().all()
				.assertThat().body("message", equalTo("Cadastro realizado com sucesso"));
	}

	@Test
	@DisplayName("Validar status code 201")
	public void validarStatusCodeCadastroProduto() {
		String payload = CadastroProdutoPayloads.payload();
		CadastroProdutoRequests.requestCadastroProdutosPost(payload).then().log().all()
				.assertThat().statusCode(201);
	}

	@Test
	@DisplayName("Validar schema json response cadastro de produtos")
	public void validarJsonSchemaCadastroProduto() {
		String schemaPath = "src/test/java/CadastroProdutos/schema/SchemaCadastroProduto.json";
		String payload = CadastroProdutoPayloads.payload();
		CadastroProdutoRequests.requestCadastroProdutosPost(payload).then().log().all()
				.body(SchemaValidator.matchesSchema(schemaPath));
	}
}
