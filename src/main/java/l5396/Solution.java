package l5396;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/17
 */
public class Solution {

    public int maxPower(String s) {
        int res = 0;
        char pre = s.charAt(0);
        int cur = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                cur++;
            } else {
                pre = s.charAt(i);
                res = Math.max(res, cur);
                cur = 1;
            }
        }
        return Math.max(res, cur);
    }
}
