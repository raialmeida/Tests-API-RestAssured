package Services.CadastroUsuarios.payloads;

import com.github.javafaker.Faker;

import jakarta.json.Json;

public class CadastroUsuarioPayloads {

	static String nameFake = Faker.instance().name().firstName();
	static String emailFake = Faker.instance().internet().emailAddress();
	static String password = Faker.instance().internet().password();

	public static String payloadCadastroUsuario(String name, String email, String password) {
		return Json.createObjectBuilder()
				.add("nome", name)
				.add("email", email)
				.add("password", password)
				.add("administrador", "true")
				.build().toString();
	}

	public static String payloadCadastroUsuario() {
		return payloadCadastroUsuario(nameFake, emailFake, password);
	}
}