package leetcode.p422;

import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public boolean validWordSquare(List<String> words) {
        for (int row = 0; row < words.size(); row++) {
            String word = words.get(row);

            for (int col = 0; col < word.length(); col++) {
                int r = col;
                int c = row;
                if (r >= words.size()) {
                    return false;
                }
                if (c >= words.get(r).length()) {
                    return false;
                }

                if (word.charAt(col) != words.get(r).charAt(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
