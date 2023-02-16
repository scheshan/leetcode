package leetcode.p2027;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/16
 */
public class Solution {

    public int minimumMoves(String s) {
        int res = 0;
        int ind = 0;

        while (ind < s.length()) {
            if (s.charAt(ind) == 'X') {
                res++;
                ind += 3;
            } else {
                ind++;
            }
        }
        return res;
    }
}
