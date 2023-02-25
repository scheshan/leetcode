package leetcode.p1247;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/25
 */
public class Solution {

    public int minimumSwap(String s1, String s2) {
        int n1 = 0, n2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    n1++;
                } else {
                    n2++;
                }
            }
        }
        if (((n1 + n2) & 1) == 1) {
            return -1;
        }

        int res = (n1 >> 1) + (n2 >> 1);
        if ((n1 & 1) == 1) {
            res += 2;
        }

        return res;
    }
}
