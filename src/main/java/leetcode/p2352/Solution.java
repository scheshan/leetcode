package leetcode.p2352;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int equalPairs(int[][] grid) {
        StringBuilder[] rows = new StringBuilder[grid.length];
        StringBuilder[] cols = new StringBuilder[grid[0].length];
        Map<String, Integer> cnt = new HashMap<>();

        for (int row = 0; row < grid.length; row++) {
            rows[row] = new StringBuilder();

            for (int col = 0; col < grid[row].length; col++) {
                if (row == 0) {
                    cols[col] = new StringBuilder();
                }

                int n = grid[row][col];
                rows[row].append(n).append(',');
                cols[col].append(n).append(',');
            }

            cnt.compute(rows[row].toString(), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        int res = 0;
        for (StringBuilder sb : cols) {
            String key = sb.toString();

            res += cnt.getOrDefault(key, 0);
        }

        return res;
    }
}
