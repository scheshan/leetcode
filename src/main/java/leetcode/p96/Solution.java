package leetcode.p96;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public int numTrees(int n) {
        int[] state = new int[n + 1];
        state[0] = 1;
        state[1] = 1;

        for (int i = 2; i <= n; i++) {
            int cnt = 0;
            for (int cur = 1; cur <= i; cur++) {
                int left = cur - 1;
                int right = i - cur;
                cnt += state[left] * state[right];
            }
            state[i] = cnt;
        }

        return state[n];
    }
}
