package interview.p16_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/7
 */
public class Solution {

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[row].length; col++) {
                if (land[row][col] == 0) {
                    list.add(dfs(land, row, col));
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    private int dfs(int[][] land, int row, int col) {
        if (row < 0 || row >= land.length || col < 0 || col >= land[row].length || land[row][col] != 0) {
            return 0;
        }
        land[row][col] = 1;
        int res = 1;
        res += dfs(land, row - 1, col - 1);
        res += dfs(land, row - 1, col);
        res += dfs(land, row - 1, col + 1);
        res += dfs(land, row, col - 1);
        res += dfs(land, row, col + 1);
        res += dfs(land, row + 1, col - 1);
        res += dfs(land, row + 1, col);
        res += dfs(land, row + 1, col + 1);
        return res;
    }
}
