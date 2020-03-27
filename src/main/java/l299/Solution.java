package l299;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/27
 */
public class Solution {

    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            map.compute(secret.charAt(i), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        int a = 0;
        int b = 0;

        for (int i = 0; i < guess.length(); i++) {
            char ch = guess.charAt(i);

            if (secret.charAt(i) == ch) {
                a++;
                map.put(ch, map.get(ch) - 1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            char ch = guess.charAt(i);
            if (secret.charAt(i) == ch) {
                continue;
            }

            if (map.containsKey(ch) && map.get(ch) > 0) {
                b++;
                map.put(ch, map.get(ch) - 1);
            }
        }

        return a + "A" + b + "B";
    }
}
