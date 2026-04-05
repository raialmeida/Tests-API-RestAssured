package Config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class TestConfig {

	static {

		// Configuração global para Allure
		RestAssured.filters(new AllureRestAssured());

		// Configuração global para log em todas as solicitações se o teste falhar.
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	public static void propertyAllure() {

		System.setProperty("allure.link.issue.pattern", "https://jira.seu-dominio.com/browse/{}");
		System.setProperty("allure.link.tms.pattern", "https://testrail.seu-dominio.com/cases/view/{}");

		// Criar arquivo de Ambiente dinamicamente
		try {
			Properties props = new Properties();

			props.setProperty("Ambiente", "Homologação");
			props.setProperty("BaseURL", RestAssured.baseURI);
			props.setProperty("OS", System.getProperty("os.name"));
			props.setProperty("User", System.getProperty("user.name"));

			File resultsDir = new File("target/allure-results");
			if (!resultsDir.exists())
				resultsDir.mkdirs();

			FileOutputStream fos = new FileOutputStream("target/allure-results/environment.properties");
			props.store(fos, "Allure Environment Properties");
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}