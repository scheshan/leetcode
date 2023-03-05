package leetcode.p1653;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/6
 */
public class Solution {

    public int minimumDeletions(String s) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a++;
            }
        }

        int res = a;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a--;
            } else {
                b++;
            }
            res = Math.min(res, a + b);
        }
        return res;
    }
}
