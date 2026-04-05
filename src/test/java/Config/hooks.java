package Config;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import Utils.UtilsUsuario;
import io.restassured.response.Response;

public class hooks {

    protected static Response usuario;

    @BeforeAll
    public static void setupAllure() {
        requestBase.baseRequest();
    }

    @BeforeEach
    public void setupConfigAllure() {
        TestConfig.propertyAllure();
        if (usuario == null) {
            usuario = UtilsUsuario.cadastrarUsuario();
        }
    }
}
