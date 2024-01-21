package leetcode.p338;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        dfs(1, n, 1, res);

        return res;
    }

    private void dfs(int num, int max, int cnt, int[] res) {
        if (num > max) {
            return;
        }

        res[num] = cnt;

        dfs(num << 1, max, cnt, res);
        dfs((num << 1) + 1, max, cnt + 1, res);
    }
}
