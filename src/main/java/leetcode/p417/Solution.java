package leetcode.p417;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] cnt = new int[heights.length][heights[0].length];

        Queue<int[]> q1 = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, cnt, i, 0, 1);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, cnt, 0, i, 1);
        }

        Queue<int[]> q2 = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, cnt, i, heights[i].length - 1, 2);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, cnt, heights.length - 1, i, 2);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int row = 0; row < cnt.length; row++) {
            for (int col = 0; col < cnt[row].length; col++) {
                if (cnt[row][col] == 3) {
                    res.add(Arrays.asList(row, col));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int[][] cnt, int row, int col, int flag) {
        if ((cnt[row][col] & flag) != 0) {
            return;
        }
        cnt[row][col] |= flag;
        if (row > 0 && heights[row - 1][col] >= heights[row][col]) {
            dfs(heights, cnt, row - 1, col, flag);
        }
        if (row < heights.length - 1 && heights[row + 1][col] >= heights[row][col]) {
            dfs(heights, cnt, row + 1, col, flag);
        }
        if (col > 0 && heights[row][col - 1] >= heights[row][col]) {
            dfs(heights, cnt, row, col - 1, flag);
        }
        if (col < heights[row].length - 1 && heights[row][col + 1] >= heights[row][col]) {
            dfs(heights, cnt, row, col + 1, flag);
        }
    }
}
