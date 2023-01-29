package leetcode.p370;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for (int[] update : updates) {
            arr[update[0]] += update[2];
            if (update[1] < length - 1) {
                arr[update[1] + 1] -= update[2];
            }
        }

        int[] res = new int[length];
        for (int i = 0; i < res.length; i++) {
            int pre = 0;
            if (i > 0) {
                pre = res[i - 1];
            }
            res[i] = pre + arr[i];
        }
        return res;
    }
}
