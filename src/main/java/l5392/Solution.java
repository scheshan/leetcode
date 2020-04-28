package l5392;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public int maxScore(String s) {
        int ones = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        int zeros = s.charAt(0) == '0' ? 1 : 0;
        int res = ones + zeros;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }
            res = Math.max(res, zeros + ones);
        }
        return res;
    }
}
