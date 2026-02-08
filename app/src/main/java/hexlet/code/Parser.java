package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.util.Map;

public class Parser {

    private static final ObjectMapper JSON_OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper YAML_OBJECT_MAPPER = new YAMLMapper();


    public static Map getData(String data) throws IOException {
        if (data.startsWith("{")) {
            return getData(JSON_OBJECT_MAPPER, data);
        } else {
            return getData(YAML_OBJECT_MAPPER, data);
        }
    }

    public static Map getData(ObjectMapper mapper, String content) throws IOException {
        return mapper.readValue(content, Map.class);
    }
}
