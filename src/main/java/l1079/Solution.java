package l1079;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            map.compute(tiles.charAt(i), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        Set<String> res = new HashSet<>();
        perm(res, map, new StringBuilder());

        return res.size();
    }

    private void perm(Set<String> res, Map<Character, Integer> map, StringBuilder sb) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                entry.setValue(entry.getValue() - 1);
                sb.append(entry.getKey());

                res.add(sb.toString());
                perm(res, map, sb);

                sb.deleteCharAt(sb.length() - 1);
                entry.setValue(entry.getValue() + 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().numTilePossibilities("AAB");
    }
}
