package leetcode.p1758;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int minOperations(String s) {
        int n1 = 0;
        int n2 = 0;

        char ch1 = '0';
        char ch2 = '1';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ch1) {
                n2++;
            } else {
                n1++;
            }

            ch1 = ch1 == '0' ? '1' : '0';
            ch2 = ch2 == '0' ? '1' : '0';
        }

        return Math.min(n1, n2);
    }
}
