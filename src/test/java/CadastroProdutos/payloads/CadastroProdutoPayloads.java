package CadastroProdutos.payloads;

import javax.json.Json;
import javax.json.JsonObject;

import com.github.javafaker.Faker;

public class CadastroProdutoPayloads {

	public static String payload() {

		JsonObject json = Json.createObjectBuilder()
                        .add("nome", "João")
                        .add("idade", "21")
                        .build();

		String jsonString = json.toString();
		// String produto = Faker.instance().commerce().productName();
		// return "{\r\n" + "  \"nome\": \"" + produto + "\",\r\n" + "  \"preco\": 470,\r\n"
		// 		+ "  \"descricao\": \"Mouse\",\r\n" + "  \"quantidade\": 381\r\n" + "}";
		return jsonString;
	}
}