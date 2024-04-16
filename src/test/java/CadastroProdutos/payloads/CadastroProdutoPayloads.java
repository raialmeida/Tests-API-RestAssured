package CadastroProdutos.payloads;

import jakarta.json.*;
import com.github.javafaker.Faker;

public class CadastroProdutoPayloads {

	public static String payload() {
		String produto = Faker.instance().commerce().productName();
		JsonObject JsonObject = Json.createObjectBuilder()
				.add("nome", produto)
				.add("preco", 470)
				.add("descricao", "Mouse")
				.add("quantidade", "381")
				.build();
		return JsonObject.toString();
	}
}