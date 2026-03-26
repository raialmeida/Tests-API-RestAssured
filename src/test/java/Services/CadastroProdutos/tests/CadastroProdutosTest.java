package Services.CadastroProdutos.tests;

import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Config.TestConfig;
import Services.CadastroProdutos.payloads.CadastroProdutoPayloads;
import Services.CadastroProdutos.requests.CadastroProdutoRequests;
import Utils.SchemaValidator;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import static io.qameta.allure.SeverityLevel.*;

@DisplayName("Testes da rota POST /produtos")
@Feature("Cadastro de Produtos")
public class CadastroProdutosTest extends TestConfig {

	String payload = CadastroProdutoPayloads.payloadCadastroProduto();

	@Test
	@Tag("Smoke")
	@DisplayName("Validar cadastro com sucesso")
	@Severity(CRITICAL)
	@Issue("345456")
	public void validarCadastroProduto() {
		CadastroProdutoRequests.requestCadastroProdutosPost(payload)
				.assertThat()
				.body("message", equalTo("Cadastro realizado com sucesso"));
	}

	@Test
	@DisplayName("Validar status code 201")
	public void validarStatusCodeCadastroProduto() {
		CadastroProdutoRequests.requestCadastroProdutosPost(payload)
				.assertThat()
				.statusCode(201);
	}

	@Test
	@DisplayName("Validar schema json response cadastro de produtos")
	public void validarJsonSchemaCadastroProduto() {
		String schemaPath = "Services/CadastroProdutos/schema/SchemaCadastroProduto.json";
		CadastroProdutoRequests.requestCadastroProdutosPost(payload)
				.body(SchemaValidator.matchesSchema(schemaPath));
	}
}