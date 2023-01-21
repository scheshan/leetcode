package leetcode.p1221;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int balancedStringSplit(String s) {
        int res = 0;

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt == 0) {
                res++;
            }
        }

        return res;
    }
}
