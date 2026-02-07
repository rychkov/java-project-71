package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
  public static String generate(String file1, String file2) throws Exception {
    Map data1 = Parser.getData(file1);
    Map data2 = Parser.getData(file2);

    StringBuffer result = new StringBuffer();
    result.append("{\n");

    Set<String> keys = new TreeSet<>();
    keys.addAll(data1.keySet());
    keys.addAll(data2.keySet());

    for (String key : keys) {
      boolean inFirst = data1.containsKey(key);
      boolean inSecond = data2.containsKey(key);

      if (inFirst && inSecond) {
        Object value1 = data1.get(key);
        Object value2 = data2.get(key);

        if (Objects.equals(value1, value2)) {
          result.append(format(" ", key, value1));
        } else {
          result.append(format("-", key, value1));
          result.append(format("+", key, value2));
        }
      } else if (inFirst) {
        result.append(format("-", key, data1.get(key)));
      } else {
        result.append(format("+", key, data2.get(key)));
      }
    }

    result.append("}\n");
    return result.toString();
  }

  private static String format(String sign, String key, Object value) {
    return String.format("  %s %s: %s%n", sign, key, value);
  }
}
