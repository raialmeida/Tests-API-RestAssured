package Services.CadastroProdutos.payloads;

import jakarta.json.*;
import com.github.javafaker.Faker;

public class CadastroProdutoPayloads {

	public static String payloadCadastroProduto() {
		String produto = Faker.instance().commerce().productName();
		return Json.createObjectBuilder()
				.add("nome", produto)
				.add("preco", 470)
				.add("descricao", "Mouse")
				.add("quantidade", "381")
				.build().toString();
	}
}