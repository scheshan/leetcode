package leetcode.p1306;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/4
 */
public class Solution {

    public boolean canReach(int[] arr, int start) {
        boolean[] visit = new boolean[arr.length];
        return dfs(arr, start, visit);
    }

    private boolean dfs(int[] arr, int i, boolean[] visit) {
        if (i < 0 || i >= arr.length || visit[i]) {
            return false;
        }
        visit[i] = true;

        boolean res = arr[i] == 0;

        res |= dfs(arr, i - arr[i], visit);
        res |= dfs(arr, i + arr[i], visit);
        return res;
    }
}
