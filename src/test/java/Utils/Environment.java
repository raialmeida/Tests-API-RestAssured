package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    /**
     * Esse método ler o caminho do arquivo definido na variável "env" definido no
     * pom.xml de acordo com perfil, retornando a variável do arquivo .properties.
     * 
     * @param key Nome da variável
     * @return
     */
    public static String getEnv(String key) {
        String env = System.getProperty("env");
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(env)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}