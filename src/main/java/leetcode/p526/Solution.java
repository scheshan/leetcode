package leetcode.p526;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int countArrangement(int n) {
        return backtrack(n, 0, new boolean[n]);
    }

    private int backtrack(int n, int ind, boolean[] used) {
        if (ind == n) {
            return 1;
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (!used[i - 1] && ((ind + 1) % i == 0 || i % (ind + 1) == 0)) {
                used[i - 1] = true;
                res += backtrack(n, ind + 1, used);
                used[i - 1] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().countArrangement(2);
    }
}
