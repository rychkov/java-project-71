package hexlet.code;

import static picocli.CommandLine.Help.Visibility.ALWAYS;

import java.io.File;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 0.0",
    description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

  @Option(names = {"-f", "--format"}, paramLabel="format", description = "output format [default: stylish]", defaultValue = "stylish")
  private String format;

  @Parameters(paramLabel = "filepath1", description = "path to first file")
  File filepath1;

  @Parameters(paramLabel = "filepath2", description = "path to second file")
  File filepath2;

  public static void main(String[] args) {
    int exitCode = new CommandLine(new App()).execute(args);
    System.exit(exitCode);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer call() throws Exception {
    return 0;
  }
}
