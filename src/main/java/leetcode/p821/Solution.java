package leetcode.p821;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = s.length() + 1;
        }

        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                res[i] = 0;
                pre = i;
            } else {
                if (pre >= 0) {
                    res[i] = Math.min(res[i], i - pre);
                }
            }
        }

        pre = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pre = i;
            } else {
                if (pre >= 0) {
                    res[i] = Math.min(res[i], pre - i);
                }
            }
        }
        return res;
    }
}
