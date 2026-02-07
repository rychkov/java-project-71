package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

  @ParameterizedTest
  @MethodSource("filePairsProvider")
  void testDiff(String file1, String file2, String diff, String format) throws IOException {
    String expected = readFixture(diff);

    App.main(new String[]{file1, file2, format});

    assertEquals(expected, output.toString(StandardCharsets.UTF_8).trim());
  }

  static Stream<Arguments> filePairsProvider() {
    return Stream.of(
        Arguments.of(
            FIXTURES_PATH + "file1.json",
            FIXTURES_PATH + "file2.json",
            "diff1_2.txt",
            "-f=stylish"
        ),
        Arguments.of(
            FIXTURES_PATH + "file1.yaml",
            FIXTURES_PATH + "file2.yaml",
            "diff1_2.txt",
            "-f=stylish"
        ),
        Arguments.of(
            FIXTURES_PATH + COMPLEX + "file1.json",
            FIXTURES_PATH + COMPLEX + "file2.json",
            COMPLEX + "diff1_2.txt",
            "-f=stylish"
        ),
        Arguments.of(
            FIXTURES_PATH + COMPLEX + "file1.yaml",
            FIXTURES_PATH + COMPLEX + "file2.yaml",
            COMPLEX + "diff1_2.txt",
            "-f=stylish"
        ),
        Arguments.of(
            FIXTURES_PATH + COMPLEX + "file1.yaml",
            FIXTURES_PATH + COMPLEX + "file2.yaml",
            COMPLEX + "diff1_2_plain.txt",
            "-f=plain"
        ),
        Arguments.of(
            FIXTURES_PATH + COMPLEX + "file1.yaml",
            FIXTURES_PATH + COMPLEX + "file2.yaml",
            COMPLEX + "diff1_2_json.txt",
            "-f=json"
        )
    );
  }

  private String readFixture(String fileName) throws IOException {
    return Files.readString(Path.of(FIXTURES_PATH + fileName));
  }
}
