package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlanFormatter;
import hexlet.code.formatters.StylishFormatter;
import java.util.List;

public class Formatter {

  public static String format(List<DiffNode> diffList, String format) throws Exception {
    var formatter = switch (format) {
      case "stylish" -> new StylishFormatter();
      case "plain" -> new PlanFormatter();
      case "json" -> new JsonFormatter();
      default -> throw new UnsupportedOperationException("Unsupported format " + format);
    };
    return formatter.format(diffList);
  }


}
