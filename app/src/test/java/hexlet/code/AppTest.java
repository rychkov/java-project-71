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

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(output));
  }

  @AfterEach
  void tearDown() {
    System.setOut(standardOut);
  }

  @Test
  void  testMain() throws IOException {
    String fileName1 = FIXTURES_PATH + "file1.json";
    String fileName2 = FIXTURES_PATH + "file2.json";
    String result = readFixture("diff1_2.txt");

    App.main(new String[]{fileName1, fileName2});
    assertEquals(result, output.toString(StandardCharsets.UTF_8).trim());

  }

  private String readFixture(String fileName) throws IOException {
    return Files.readString(Path.of(FIXTURES_PATH + fileName));
  }
}
