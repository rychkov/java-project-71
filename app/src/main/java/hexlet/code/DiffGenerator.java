package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DiffGenerator {

    public static List<DiffNode> generateDiff(Map data1, Map data2) {
        List<DiffNode> diffList = new ArrayList<>();

        Set<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());

        for (String key : keys) {
            boolean inFirst = data1.containsKey(key);
            boolean inSecond = data2.containsKey(key);

            if (inFirst && inSecond) {
                Object value1 = data1.get(key);
                Object value2 = data2.get(key);

                if (Objects.equals(value1, value2)) {
                    diffList.add(new DiffNode(key, Status.UNCHANGED, value1, value2));
                } else {
                    diffList.add(new DiffNode(key, Status.CHANGED, value1, value2));
                }
            } else if (inFirst) {
                diffList.add(new DiffNode(key, Status.REMOVED, data1.get(key), null));
            } else {
                diffList.add(new DiffNode(key, Status.ADDED, null, data2.get(key)));
            }
        }
        return diffList;
    }
}
