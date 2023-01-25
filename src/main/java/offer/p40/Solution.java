package offer.p40;

import java.util.Arrays;

/**
 * Solutio
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
