package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlanFormatter;
import hexlet.code.formatters.StylishFormatter;
import java.util.List;

public class Formatter {

  public static final String STYLISH = "stylish";
  public static final String PLAIN = "plain";
  public static final String JSON = "json";

  public static String format(List<DiffNode> diffList, String format) throws Exception {
    var formatter = switch (format) {
      case STYLISH -> new StylishFormatter();
      case PLAIN -> new PlanFormatter();
      case JSON -> new JsonFormatter();
      default -> throw new UnsupportedOperationException("Unsupported format " + format);
    };
    return formatter.format(diffList);
  }


}
