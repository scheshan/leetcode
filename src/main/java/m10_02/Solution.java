package m10_02;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String hash = hash(str);
            map.compute(hash, (k, v) -> {
                if (v == null) {
                    v = new LinkedList<>();
                }
                v.add(str);
                return v;
            });
        }

        List<List<String>> res = new ArrayList<>(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }

    private String hash(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);

        return new String(ch);
    }
}
