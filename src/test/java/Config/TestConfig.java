package Config;

import static io.restassured.RestAssured.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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
		baseURI = TestConfig.getEnv("baseURI");
		UtilsUsuario.cadastrarUsuario();
	}

	public static String getEnv(String key) {
		String env = System.getProperty("env");
		Properties properties = new Properties();
		try (FileInputStream input = new FileInputStream(env)) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
}