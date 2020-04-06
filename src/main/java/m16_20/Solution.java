package m16_20;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/6
 */
public class Solution {

    public List<String> getValidT9Words(String num, String[] words) {
        char[] map = {'2','2','2','3','3','3','4','4','4','5','5','5','6','6','6','7','7','7','7','8','8','8','9','9','9','9'};
        List<String> res = new LinkedList<>();

        for (String word : words) {
            word = word.toLowerCase();
            boolean valid = true;
            for (int i = 0; i < word.length(); i++) {
                if (map[word.charAt(i) - 'a'] != num.charAt(i)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                res.add(word);
            }
        }

        return res;
    }
}
