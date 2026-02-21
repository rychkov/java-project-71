package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static final String FIXTURES_PATH = "src/test/resources/fixtures/";
    private static final String COMPLEX = "complex/";

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    void testDiffWithDefaultFormat(String file1, String file2, String diff) throws IOException {
        String expected = readFixture(diff);

        App.main(new String[]{file1, file2});

        assertEquals(expected, output.toString(StandardCharsets.UTF_8).trim());
    }

    void testDiff(String file1, String file2, String diff, String format) throws IOException {
        String expected = readFixture(diff);

        App.main(new String[]{"-f", format, file1, file2});

        assertEquals(expected, output.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    void testSimpleCaseJsonInput_StylishOutput() throws Exception {
        testDiff(FIXTURES_PATH + "file1.json", FIXTURES_PATH + "file2.json", "diff1_2.txt", Formatter.STYLISH);
    }

    @Test
    void testSimpleCaseYamlInput_StylishOutput() throws Exception {
        testDiff(FIXTURES_PATH + "file1.yaml", FIXTURES_PATH + "file2.yaml", "diff1_2.txt", Formatter.STYLISH);
    }

    @Test
    void testSimpleCaseJsonInput_JsonOutput() throws Exception {
        testDiff(FIXTURES_PATH + "file1.json", FIXTURES_PATH + "file2.json", "diff1_2_json.txt", Formatter.JSON);
    }

    @Test
    void testSimpleCaseYamlInput_JsonOutput() throws Exception {
        testDiff(FIXTURES_PATH + "file1.yaml", FIXTURES_PATH + "file2.yaml", "diff1_2_json.txt", Formatter.JSON);
    }

    @Test
    void testComplexCaseJsonInput_StylishOutput() throws Exception {
        testDiff(FIXTURES_PATH + COMPLEX + "file1.json", FIXTURES_PATH + COMPLEX + "file2.json",
            COMPLEX + "diff1_2.txt", Formatter.STYLISH);
    }

    @Test
    void testComplexCaseYamlInput_StylishOutput() throws Exception {
        testDiff(FIXTURES_PATH + COMPLEX + "file1.yaml", FIXTURES_PATH + COMPLEX + "file2.yaml",
            COMPLEX + "diff1_2.txt", Formatter.STYLISH);
    }

    @Test
    void testComplexCaseYamlInput_PlainOutput() throws Exception {
        testDiff(FIXTURES_PATH + COMPLEX + "file1.yaml", FIXTURES_PATH + COMPLEX + "file2.yaml",
            COMPLEX + "diff1_2_plain.txt", Formatter.PLAIN);
    }

    @Test
    void testComplexCaseYamlInput_JsonOutput() throws Exception {
        testDiff(FIXTURES_PATH + COMPLEX + "file1.yaml", FIXTURES_PATH + COMPLEX + "file2.yaml",
            COMPLEX + "diff1_2_json.txt", Formatter.JSON);
    }

    @Test
    void testSimpleCaseJsonInput_DefaultOutput() throws Exception {
        testDiffWithDefaultFormat(FIXTURES_PATH + "file1.json", FIXTURES_PATH + "file2.json", "diff1_2.txt");
    }

    @Test
    void testSimpleCaseYamlInput_DefaultOutput() throws Exception {
        testDiffWithDefaultFormat(FIXTURES_PATH + "file1.yaml", FIXTURES_PATH + "file2.yaml", "diff1_2.txt");
    }

    private String readFixture(String fileName) throws IOException {
        return Files.readString(Path.of(FIXTURES_PATH + fileName));
    }
}
