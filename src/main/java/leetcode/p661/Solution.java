package leetcode.p661;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];

        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[row].length; col++) {
                int total = 0;
                int cnt = 0;

                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (i >= 0 && i < res.length && j >= 0 && j < res[i].length) {
                            total += img[i][j];
                            cnt++;
                        }
                    }
                }
                res[row][col] = total / cnt;
            }
        }
        return res;
    }
}
