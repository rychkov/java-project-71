package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(String file1, String file2) throws Exception {
        return generate(file1, file2, "stylish");
    }

    public static String generate(String file1, String file2, String format) throws Exception {
//    System.out.println("File1 :" + file1);
//    System.out.println("File2 :" + file2);
        Map data1 = Parser.getData(getContent(file1));
//    System.out.println("Map1 " + data1);
        Map data2 = Parser.getData(getContent(file2));
//    System.out.println("Map2 " + data2);

        List<DiffNode> diffList = DiffGenerator.generateDiff(data1, data2);
        return Formatter.format(diffList, format);
    }

    private static String getContent(String name) throws Exception {
        Path path = Path.of(name);
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        return Files.readString(path);
    }
}
