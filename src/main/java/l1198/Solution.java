package l1198;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public int smallestCommonElement(int[][] mat) {
        int[] count = new int[10001];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                count[mat[i][j]]++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == mat.length) {
                return i;
            }
        }
        return -1;
    }
}
