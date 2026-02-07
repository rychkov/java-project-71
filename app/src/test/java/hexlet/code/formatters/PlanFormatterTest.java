package hexlet.code.formatters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PlanFormatterTest {

  @Test
  void testMap() {
    assertEquals(PlanFormatter.COMPLEX_VALUE, PlanFormatter.getValueString(Map.of()));
  }

  @Test
  void testCollection() {
    assertEquals(PlanFormatter.COMPLEX_VALUE, PlanFormatter.getValueString(List.of()));
  }

  @Test
  void testArray() {
    assertEquals(PlanFormatter.COMPLEX_VALUE, PlanFormatter.getValueString(new String[]{"q"}));
  }

  @Test
  void testString() {
    assertEquals("''", PlanFormatter.getValueString(""));
  }

  @Test
  void testBoolean() {
    assertEquals("false", PlanFormatter.getValueString(false));
  }

  @Test
  void testInt() {
    assertEquals("1", PlanFormatter.getValueString(1));
  }
}
