package leetcode.p329;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        Queue<int[]> queue = new PriorityQueue<>(matrix.length * matrix[0].length, (o1, o2) -> {
            return Integer.compare(matrix[o1[0]][o1[1]], matrix[o2[0]][o2[1]]);
        });

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                queue.add(new int[]{i, j});
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int[] arr = queue.remove();
            int row = arr[0], col = arr[1];

            dp[row][col] = 1;
            if (row > 0 && matrix[row - 1][col] < matrix[row][col]) {
                dp[row][col] = Math.max(dp[row][col], dp[row - 1][col] + 1);
            }
            if (row < matrix.length - 1 && matrix[row + 1][col] < matrix[row][col]) {
                dp[row][col] = Math.max(dp[row][col], dp[row + 1][col] + 1);
            }
            if (col > 0 && matrix[row][col - 1] < matrix[row][col]) {
                dp[row][col] = Math.max(dp[row][col], dp[row][col - 1] + 1);
            }
            if (col < matrix[row].length - 1 && matrix[row][col + 1] < matrix[row][col]) {
                dp[row][col] = Math.max(dp[row][col], dp[row][col + 1] + 1);
            }

            res = Math.max(res, dp[row][col]);
        }

        return res;
    }
}
