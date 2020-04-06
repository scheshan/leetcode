package l1343;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/6
 */
public class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int n = k * threshold;
        int res = 0;
        for (int i = k; i < prefix.length; i++) {
            if (prefix[i] - prefix[i - k] >= n) {
                res++;
            }
        }

        return res;
    }
}
