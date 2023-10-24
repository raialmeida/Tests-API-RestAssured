package CadastroUsuarios.payloads;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class CadastroUsuarioPayloads {

	static Name name = Faker.instance().name();
	static String email = Faker.instance().internet().emailAddress();
	static String password = Faker.instance().internet().password();

	public static String payload() {
		return "{\r\n" + "  \"nome\": \"" + name + "\"," + "  \"email\": \"" + email + "\"," + "  \"password\": \""
				+ password + "\"," + "  \"administrador\": \"true\"\r\n" + "}";
	}
}