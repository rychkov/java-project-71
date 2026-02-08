package hexlet.code.formatters;

import hexlet.code.DiffNode;
import java.util.List;

public interface Format {

    /**
     * Get formatted output.
     *
     * @param diffList diff list
     * @return output
     */
    String format(List<DiffNode> diffList) throws Exception;
}
