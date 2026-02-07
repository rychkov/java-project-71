package hexlet.code.formatters;

import hexlet.code.DiffNode;
import java.util.List;

public class PlanFormatter implements Format {
  public static final String COMPLEX_VALUE = "[complex value]";

  /**
   * {@inheritDoc}
   */
  @Override
  public String format(List<DiffNode> diffList) throws Exception {
    StringBuilder result = new StringBuilder();
    for (DiffNode node : diffList) {
      switch (node.status()) {
        case ADDED -> result.append("Property '%s' was added with value: %s%n".formatted(node.key(),
            getValueString(node.newValue())));
        case CHANGED -> result.append("Property '%s' was updated. From %s to %s%n".formatted(node.key(),
            getValueString(node.oldValue()), getValueString(node.newValue())));
        case REMOVED -> result.append("Property '%s' was removed%n".formatted(node.key()));
        case UNCHANGED -> {
          //nop
        }
        default -> throw new UnsupportedOperationException("Unexpected status " + node.status());
      }
    }
    return result.toString();
  }

  static String getValueString(Object value) {
    if (value == null) {
      return null;
    } else if (value instanceof String) {
      return "'%s'".formatted(value);
    } else if (value instanceof Number || value instanceof Boolean) {
      return value.toString();
    }
    return COMPLEX_VALUE;
  }
}
