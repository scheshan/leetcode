package leetcode.p2609;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/8
 */
public class Solution {

    public int findTheLongestBalancedSubstring(String s) {
        int res = 0, ind = 0;

        while (ind < s.length()) {
            int n1 = 0, n2 = 0;
            while (ind < s.length() && s.charAt(ind) == '0') {
                n1++;
                ind++;
            }
            while (ind < s.length() && s.charAt(ind) == '1') {
                n2++;
                ind++;
            }

            int n = Math.min(n1, n2);
            res = Math.max(res, n << 1);
        }

        return res;
    }
}
