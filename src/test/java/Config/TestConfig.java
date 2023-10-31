package Config;

import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.BeforeAll;
import Utils.UtilsUsuario;

public class TestConfig {

	@BeforeAll
	public static void setup() {
		baseURI = System.getProperty("baseURI");
		UtilsUsuario.cadastrarUsuario();
	}
}