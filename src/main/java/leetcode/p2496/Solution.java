package leetcode.p2496;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int maximumValue(String[] strs) {
        int res = 0;
        for (String str : strs) {
            res = Math.max(res, cal(str));
        }
        return res;
    }

    private int cal(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res = res * 10 + str.charAt(i) - '0';
            } else {
                return str.length();
            }
        }
        return res;
    }
}
