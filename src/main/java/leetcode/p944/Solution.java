package leetcode.p944;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int minDeletionSize(String[] strs) {
        int res = 0;

        for (int col = 0; col < strs[0].length(); col++) {
            for (int row = 1; row < strs.length; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
