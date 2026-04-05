package Config;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import Utils.UtilsUsuario;

public class hooks {

    @BeforeAll
    public static void setupAllure() {
        TestConfig.configAllure();
    }

    @BeforeEach
    public void setupConfigAllure() {
        requestBase.baseRequest();
        TestConfig.configAllure();
        UtilsUsuario.cadastrarUsuario();
    }
}
