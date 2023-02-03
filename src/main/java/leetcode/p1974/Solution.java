package leetcode.p1974;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int minTimeToType(String word) {
        char cur = 'a';
        int res = 0;

        for (int i = 0; i < word.length(); i++) {
            res += Math.min(Math.abs(word.charAt(i) - cur), 26 - Math.abs(word.charAt(i) - cur)) + 1;
            cur = word.charAt(i);
        }
        return res;
    }
}
