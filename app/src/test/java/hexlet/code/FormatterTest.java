package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FormatterTest {

  @Test
  void testUnsupportedFormat() {
    assertThrows(UnsupportedOperationException.class, () ->
        Formatter.format(Collections.emptyList(), "invalid")
    );
  }

  @ParameterizedTest
  @CsvSource({
      "plain, ''",       // Ожидаем пустую строку для plain
      "stylish, '{\n}'",   // Ожидаем пустые скобки для stylish
      "json, '{\n  \"diff\" : [ ]\n}'"       // Ожидаем пустой массив для json
  })
  void testValidFormats(String format, String expectedOutput) throws Exception {
    String result = Formatter.format(Collections.emptyList(), format);

    assertEquals(expectedOutput, result, "Format '" + format + "' should handle empty list correctly");
  }
}
