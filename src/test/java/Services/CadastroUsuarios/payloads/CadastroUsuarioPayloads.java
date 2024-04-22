package Services.CadastroUsuarios.payloads;

import com.github.javafaker.Faker;
import jakarta.json.*;

public class CadastroUsuarioPayloads {

	static String name = Faker.instance().name().toString();
	static String email = Faker.instance().internet().emailAddress();
	static String password = Faker.instance().internet().password();

	public static String payloadCadastroUsuario() {
		return Json.createObjectBuilder()
				.add("nome", name)
				.add("email", email)
				.add("password", password)
				.add("administrador", "true")
				.build().toString();
	}
}