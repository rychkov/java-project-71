package hexlet.code;

import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 0.0",
    description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
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
