package l791;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            map.compute(T.charAt(i), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        char[] res = new char[T.length()];
        int i = 0;

        for (int j = 0; j < S.length(); j++) {
            if (map.containsKey(S.charAt(j))) {
                for (int k = 0; k < map.get(S.charAt(j)); k++) {
                    res[i++] = S.charAt(j);
                }
                map.remove(S.charAt(j));
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int k = 0; k < entry.getValue(); k++) {
                res[i++] = entry.getKey();
            }
        }

        return new String(res);
    }
}
