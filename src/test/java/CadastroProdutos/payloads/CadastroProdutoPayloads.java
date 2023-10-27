package CadastroProdutos.payloads;

import com.github.javafaker.Faker;

public class CadastroProdutoPayloads {

	public static String payload() {
		String produto = Faker.instance().commerce().productName();
		return "{\r\n" + "  \"nome\": \"" + produto + "\",\r\n" + "  \"preco\": 470,\r\n"
				+ "  \"descricao\": \"Mouse\",\r\n" + "  \"quantidade\": 381\r\n" + "}";
	}
}