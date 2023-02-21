package leetcode.p921;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/21
 */
public class Solution {

    public int minAddToMakeValid(String s) {
        int res = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    res++;
                }
            }
        }
        return res + left;
    }
}
