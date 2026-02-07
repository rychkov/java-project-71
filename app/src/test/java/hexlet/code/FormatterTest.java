package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class FormatterTest {

  @Test
  void testUnsupportedFormat() {
    assertThrows(UnsupportedOperationException.class, () ->
        Formatter.format(Collections.emptyList(), "invalid")
    );
  }

  @Test
  void testFileDoesNotExist() {
    assertThrows(Exception.class, () ->
        App.main(new String[]{"non-existent.json", "file2.json"})
    );
  }
}
