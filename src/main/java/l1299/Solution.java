package l1299;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];

        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                res[i] = -1;
            } else {
                res[i] = max;
            }
            max = Math.max(max, arr[i]);
        }

        return res;
    }
}
