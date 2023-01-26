package leetcode.p2325;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char cur = 'a';
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (ch != ' ' && !map.containsKey(ch)) {
                map.put(ch, cur);
                cur++;
            }
        }

        char[] res = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                res[i] = ' ';
            } else {
                res[i] = map.get(message.charAt(i));
            }
        }
        return new String(res);
    }
}
