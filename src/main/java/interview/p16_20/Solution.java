package interview.p16_20;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public List<String> getValidT9Words(String num, String[] words) {
        int[] ind = new int[]{2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};

        List<String> res = new ArrayList<>();
        for (String word : words) {
            boolean valid = true;
            for (int i = 0; i < word.length(); i++) {
                if (ind[word.charAt(i) - 'a'] != num.charAt(i) - '0') {
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
