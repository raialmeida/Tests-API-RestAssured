package Services.CadastroProdutos.payloads;

import com.github.javafaker.Faker;

import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;

public class CadastroProdutoPayloads {

	public static String payloadCadastroProduto(String produto, Integer preco) {

		JsonObjectBuilder builder = Json.createObjectBuilder()
				.add("nome", produto)
				.add("descricao", "Mouse")
				.add("quantidade", "381");

		if (preco != null) {
			builder.add(preco != null ? "preco" : "", preco);
		}
		return builder.build().toString();
	}

	public static String payloadCadastroProduto() {

		String produtoFaker = Faker.instance().commerce().productName();
		return payloadCadastroProduto(produtoFaker, 470);
	}
}