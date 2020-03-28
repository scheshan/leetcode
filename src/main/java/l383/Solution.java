package l383;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/28
 */
public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.compute(magazine.charAt(i), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            Integer count = map.get(ch);
            if (count == null || count < 1) {
                return false;
            }

            map.put(ch, count - 1);
        }

        return true;
    }
}
