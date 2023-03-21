package leetcode.p1784;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/21
 */
public class Solution {

    public boolean checkOnesSegment(String s) {
        int cnt = 0;
        int ind = 0;

        while (ind < s.length()) {
            if (s.charAt(ind) == '1') {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                while (ind < s.length() && s.charAt(ind) == '1') {
                    ind++;
                }
            } else {
                ind++;
            }
        }
        return true;
    }
}
