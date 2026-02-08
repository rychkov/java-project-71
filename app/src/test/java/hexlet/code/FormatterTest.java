package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
// JaCoCo has issues with ParameterizedTest
//    @ParameterizedTest
//    @CsvSource({
//        Formatter.PLAIN + ", ''",       // Ожидаем пустую строку для plain
//        Formatter.STYLISH + ", '{\n}'",   // Ожидаем пустые скобки для stylish
//        Formatter.JSON + ", '{\n  \"diff\" : [ ]\n}'"       // Ожидаем пустой массив для json
//    })
//    void testValidFormats(String format, String expectedOutput) throws Exception {
//        String result = Formatter.format(Collections.emptyList(), format);
//
//        assertEquals(expectedOutput, result, "Format '" + format + "' should handle empty list correctly");
//    }

    @Test
    void testJsonFormats() throws Exception {
        String format = Formatter.JSON;
        String result = Formatter.format(Collections.emptyList(), format);

        assertEquals("{\n  \"diff\" : [ ]\n}", result, "Format '" + format + "' should handle empty list correctly");
    }

    @Test
    void testPlainFormats() throws Exception {
        String format = Formatter.PLAIN;
        String result = Formatter.format(Collections.emptyList(), format);

        assertEquals("", result, "Format '" + format + "' should handle empty list correctly");
    }

    @Test
    void testStylishFormats() throws Exception {
        String format = Formatter.STYLISH;
        String result = Formatter.format(Collections.emptyList(), format);

        assertEquals("{\n}", result, "Format '" + format + "' should handle empty list correctly");
    }
}
