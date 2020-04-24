package l1100;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public int numKLenSubstrNoRepeats(String S, int K) {
        if (K > S.length()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            compute(map, S.charAt(i), 1);
        }

        int res = map.size() == K ? 1 : 0;
        for (int i = K; i < S.length(); i++) {
            compute(map, S.charAt(i), 1);
            compute(map, S.charAt(i - K), -1);

            if (map.size() == K) {
                res++;
            }
        }
        return res;
    }

    private void compute(Map<Character, Integer> map, char key, int count) {
        int c = map.compute(key, (k, v) -> {
            if (v == null) {
                v = 0;
            }
            return v + count;
        });
        if (c <= 0) {
            map.remove(key);
        }
    }
}
