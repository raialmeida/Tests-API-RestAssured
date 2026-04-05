package Config;

import Utils.Environment;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class requestBase {

    public static RequestSpecification reqSpec;

    public static RequestSpecification baseRequest() {
        return reqSpec = new RequestSpecBuilder()
                .setBaseUri(Environment.getEnv("baseURI"))
                .build();
    }
}
