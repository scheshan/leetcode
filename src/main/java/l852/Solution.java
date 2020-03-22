package l852;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int peakIndexInMountainArray(int[] A) {
        int res = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                res = i;
            }
        }

        return res;
    }
}
