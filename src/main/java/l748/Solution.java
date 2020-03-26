package l748;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = lower(licensePlate.charAt(i));
            add(map, ch);
        }

        String res = null;

        for (String word : words) {
            Map<Character, Integer> m = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char ch = lower(word.charAt(i));
                if (map.containsKey(ch)) {
                    add(m, ch);
                }
            }

            if (map.size() == m.size()) {
                boolean match = true;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (!(m.containsKey(entry.getKey()) && m.get(entry.getKey()) >= entry.getValue())) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    if (res == null || res.length() > word.length()) {
                        res = word;
                    }
                }
            }

        }


        return res;
    }

    private void add(Map<Character, Integer> map, char ch) {
        if (ch >= 'a' && ch <= 'z') {

        } else {
            return;
        }

        map.compute(ch, (k, v) -> {
            if (v == null) {
                v = 0;
            }
            return ++v;
        });
    }

    private char lower(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch |= ' ';
        }
        return ch;
    }

    public static void main(String[] args) {
        new Solution().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
    }
}
