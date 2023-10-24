package Config;

import static io.restassured.RestAssured.baseURI;

import org.junit.jupiter.api.BeforeAll;

public class TestConfig {

	@BeforeAll
	public static void setup() {
		baseURI = "https://serverest.dev";
	}
}