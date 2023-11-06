package Utils;

import java.io.File;
import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaValidator {

    /**
     * 
     * @param schemaFilePath Caminho do arquivo com schema
     * @return Validação do schema
     */
    public static JsonSchemaValidator matchesSchema(String schemaFilePath){
        File schemaFile = new File(schemaFilePath);
        return JsonSchemaValidator.matchesJsonSchema(schemaFile);
    }
}
