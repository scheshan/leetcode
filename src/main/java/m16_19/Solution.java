package m16_19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    list.add(dfs(land, i, j));
                }
            }
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list) {
            result[i++] = num;
        }

        return result;
    }

    private int dfs(int[][] land, int i, int j) {
        if (i < 0 || j < 0 || i >= land.length || j >= land[i].length || land[i][j] != 0) {
            return 0;
        }

        land[i][j] = -1;
        int res = 1;

        res += dfs(land, i - 1, j);
        res += dfs(land, i + 1, j);
        res += dfs(land, i, j - 1);
        res += dfs(land, i, j + 1);
        res += dfs(land, i - 1, j - 1);
        res += dfs(land, i - 1, j + 1);
        res += dfs(land, i + 1, j - 1);
        res += dfs(land, i + 1, j + 1);

        return res;
    }
}
