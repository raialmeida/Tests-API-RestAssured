package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    private static final Properties properties = new Properties();
    private static boolean loaded = false;
    private static String loadedEnv;

    private Environment() {
    }

    private static void loadProperties() {
        if (loaded) {
            return;
        }
        String env = System.getProperty("env");

        // Fallback para execução direta no VS Code
        if (env == null || env.isBlank()) {
            env = "src/test/resources/dev.properties";
        }

        try (FileInputStream input = new FileInputStream(env)) {
            properties.load(input);
            loaded = true;
            loadedEnv = env;
            System.out.println("Arquivo de ambiente carregado: " + env);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de ambiente: " + env, e);
        }
    }

    /**
     * Esse método ler o caminho do arquivo definido na variável "env" definido no
     * pom.xml de acordo com perfil, retornando a variável do arquivo .properties.
     * 
     * @param key Nome da variável
     * @return
     */
    public static String getEnv(String key) {
        loadProperties();
        String value = properties.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new RuntimeException(
                    "Chave '" + key + "' não encontrada no arquivo: " + loadedEnv);
        }
        return value;
    }
}