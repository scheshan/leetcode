package lcp7;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int numWays(int n, int[][] relation, int k) {
        List<Integer>[] arr = new List[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<>();
        }
        for (int[] r : relation) {
            arr[r[0]].add(r[1]);
        }

        return dfs(arr, 0, k);
    }

    private int dfs(List<Integer>[] arr, int i, int cur) {
        if (cur == 0) {
            if (i == arr.length - 1) {
                return 1;
            }
            return 0;
        }

        int res = 0;
        List<Integer> relation = arr[i];
        for (int num : relation) {
            res += dfs(arr, num, cur - 1);
        }
        return res;
    }
}
