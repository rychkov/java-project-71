package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DifferTest {

    @Test
    void testFileDoesNotExist() {
        assertThrows(Exception.class, () -> Differ.generate("non-existent.json", "file2.json"));
    }
}
