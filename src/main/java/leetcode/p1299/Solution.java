package leetcode.p1299;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int[] replaceElements(int[] arr) {
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int n = arr[i];
            if (i == arr.length - 1) {
                arr[i] = -1;
            } else {
                arr[i] = max;
            }
            max = Math.max(max, n);
        }
        return arr;
    }
}
