package services.CadastroProdutos.tests;

import static io.restassured.RestAssured.basePath;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Config.TestConfig;
import Utils.SchemaValidator;
import services.CadastroProdutos.payloads.CadastroProdutoPayloads;
import services.CadastroProdutos.requests.CadastroProdutoRequests;

@DisplayName("Testes da rota POST /produtos")
public class CadastroProdutosTest extends TestConfig {

	String payload = CadastroProdutoPayloads.payloadCadastroProduto();

	@BeforeEach
	public void before() {
		basePath = "/produtos";
	}

	@Test
	@DisplayName("Validar cadastro com sucesso")
	public void validarCadastroProduto() {
		CadastroProdutoRequests.requestCadastroProdutosPost(payload).then()
				.assertThat().body("message", equalTo("Cadastro realizado com sucesso"));
	}

	@Test
	@DisplayName("Validar status code 201")
	public void validarStatusCodeCadastroProduto() {
		CadastroProdutoRequests.requestCadastroProdutosPost(payload).then()
				.assertThat().statusCode(201);
	}

	@Test
	@DisplayName("Validar schema json response cadastro de produtos")
	public void validarJsonSchemaCadastroProduto() {
		String schemaPath = "services/CadastroProdutos/schema/SchemaCadastroProduto.json";
		CadastroProdutoRequests.requestCadastroProdutosPost(payload).then()
				.body(SchemaValidator.matchesSchema(schemaPath));
	}
}