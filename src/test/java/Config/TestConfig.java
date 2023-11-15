package Config;

import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.BeforeAll;
import Utils.UtilsUsuario;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class TestConfig {

	static {
		// Configuração global para Allure
		RestAssured.filters(new AllureRestAssured());

		// Configuração global para log em todas as solicitações se o teste falhar.
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@BeforeAll
	public static void setup() {
		baseURI = System.getProperty("baseURI");
		UtilsUsuario.cadastrarUsuario();
	}
}