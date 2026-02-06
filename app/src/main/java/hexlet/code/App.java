package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 0.0",
    description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

  @Option(names = {"-f", "--format"},
      paramLabel = "format",
      description = "output format [default: stylish]",
      defaultValue = "stylish")
  private String format;

  @Parameters(paramLabel = "filepath1", description = "path to first file")
  private Path filepath1;

  @Parameters(paramLabel = "filepath2", description = "path to second file")
  private Path filepath2;

  public static void main(String[] args) {
    int exitCode = new CommandLine(new App()).execute(args);
    System.exit(exitCode);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer call() throws Exception {
    System.out.println(Differ.generate(getContent(filepath1), getContent(filepath2)));
    return 0;
  }

  private static String getContent(Path path) throws Exception {
    if (!Files.exists(path)) {
      throw new Exception("File '" + path + "' does not exist");
    }

    return Files.readString(path);
  }
}
