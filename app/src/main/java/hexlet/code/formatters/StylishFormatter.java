package hexlet.code.formatters;

import hexlet.code.DiffNode;
import java.util.List;

public class StylishFormatter implements Format {

  /**
   * {@inheritDoc}
   */
  @Override
  public String format(List<DiffNode> diffList) throws Exception {
    StringBuilder result = new StringBuilder();
    result.append("{\n");
    for (DiffNode node : diffList) {
      switch (node.status()) {
        case ADDED:
          result.append(format("+", node.key(), node.newValue()));
          break;
        case CHANGED:
          result.append(format("-", node.key(), node.oldValue()));
          result.append(format("+", node.key(), node.newValue()));
          break;
        case REMOVED:
          result.append(format("-", node.key(), node.oldValue()));
          break;
        case UNCHANGED:
          result.append(format(" ", node.key(), node.newValue()));
          break;
        default: throw new UnsupportedOperationException("Unexpected status " + node.status());
      }
    }
    result.append("}");
    return result.toString();
  }

  private static String format(String sign, String key, Object value) {
    return String.format("  %s %s: %s%n", sign, key, value);
  }
}
