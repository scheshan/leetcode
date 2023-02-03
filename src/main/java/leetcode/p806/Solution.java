package leetcode.p806;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int[] numberOfLines(int[] widths, String s) {
        if (s.length() == 0) {
            return new int[]{0, 0};
        }

        int rows = 1;
        int cols = 0;

        for (int i = 0; i < s.length(); i++) {
            if (cols + widths[s.charAt(i) - 'a'] > 100) {
                rows++;
                cols = 0;
            }
            cols += widths[s.charAt(i) - 'a'];
        }

        return new int[]{rows, cols};
    }
}
