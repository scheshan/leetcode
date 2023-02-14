package leetcode.p434;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int countSegments(String s) {
        int res = 0;
        int ind = 0;
        while (ind < s.length()) {
            int pre = ind;
            while (ind < s.length() && s.charAt(ind) != ' ') {
                ind++;
            }
            if (pre != ind) {
                res++;
            }
            while (ind < s.length() && s.charAt(ind) == ' ') {
                ind++;
            }
        }
        return res;
    }
}
