package leetcode.p1487;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/3
 */
public class Solution {

    public String[] getFolderNames(String[] names) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String originalName = names[i];
            String name = originalName;
            int ind = map.getOrDefault(originalName, 0);
            while (set.contains(name)) {
                ind++;
                name = originalName + "(" + String.valueOf(ind) + ")";
            }

            map.put(originalName, ind);

            set.add(name);
            res[i] = name;
        }

        return res;
    }
}
