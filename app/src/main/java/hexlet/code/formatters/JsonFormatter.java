package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DiffNode;
import java.util.List;
import java.util.Map;

public class JsonFormatter implements Format {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  public static final String DIFF_KEY = "diff";

  /**
   * {@inheritDoc}
   */
  @Override
  public String format(List<DiffNode> diffList) throws Exception {
    return OBJECT_MAPPER.writerWithDefaultPrettyPrinter()
        .writeValueAsString(Map.of(DIFF_KEY, diffList));
  }
}
