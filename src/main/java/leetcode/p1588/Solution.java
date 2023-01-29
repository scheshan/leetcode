package leetcode.p1588;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int sumOddLengthSubarrays(int[] arr) {
        int[] pre = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }

        int res = 0;
        for (int step = 0; step <= arr.length; step += 2) {
            for (int i = step; i < arr.length; i++) {
                res += pre[i + 1] - pre[i - step];
            }
        }
        return res;
    }
}
