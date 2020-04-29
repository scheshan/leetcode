package l852;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
