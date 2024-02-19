package leetcode.p926;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/19
 */
public class Solution {

    public int minFlipsMonoIncr(String s) {
        int n0 = 0, n1 = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int m0, m1;
            if (ch == '0') {
                m0 = n0;
                m1 = Math.min(n0, n1) + 1;
            } else {
                m0 = n0 + 1;
                m1 = Math.min(n0, n1);
            }
            n0 = m0;
            n1 = m1;
        }

        return Math.min(n0, n1);
    }
}
