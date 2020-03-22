package l806;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] numberOfLines(int[] widths, String S) {
        if (S.length() == 0) {
            return new int[]{0, 0};
        }

        int rows = 1;
        int cols = 0;

        for (int i = 0; i < S.length(); i++) {
            int w = widths[S.charAt(i) - 'a'];

            if (cols + w > 100) {
                rows++;
                cols = w;
            } else {
                cols += w;
            }
        }

        return new int[]{rows, cols};
    }
}
