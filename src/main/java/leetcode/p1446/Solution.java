package leetcode.p1446;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int maxPower(String s) {
        int res = 0;
        char pre = ' ';
        int cur = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                cur++;
            } else {
                cur = 1;
            }
            pre = s.charAt(i);
            res = Math.max(res, cur);
        }
        return res;
    }
}
