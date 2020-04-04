package m16_15;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/4
 */
public class Solution {

    public int[] masterMind(String solution, String guess) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < solution.length(); i++) {
            map1.compute(solution.charAt(i), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        int c1 = 0;
        int c2 = 0;

        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < guess.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                c1++;
                int count = map1.get(guess.charAt(i));
                count--;
                map1.put(guess.charAt(i), count);
            } else {
                map2.compute(guess.charAt(i), (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    return ++v;
                });
            }
        }

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (map1.containsKey(entry.getKey())) {
                c2 += Math.min(entry.getValue(), map1.get(entry.getKey()));
            }
        }

        return new int[]{c1, c2};
    }
}
