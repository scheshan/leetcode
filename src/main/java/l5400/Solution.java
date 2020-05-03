package l5400;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/3
 */
public class Solution {

    public String destCity(List<List<String>> paths) {
        Map<String, Integer> out = new HashMap<>();
        for (List<String> path : paths) {
            out.put(path.get(0), out.getOrDefault(path.get(0), 0) + 1);
            out.put(path.get(1), out.getOrDefault(path.get(1), 0));
        }

        for (Map.Entry<String, Integer> entry : out.entrySet()) {
            if (entry.getValue() == 0) {
                return entry.getKey();
            }
        }
        return null;
    }
}
