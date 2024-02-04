package lcr.p069;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/4
 */
public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            int pre = Integer.MIN_VALUE;
            if (mid > 0) {
                pre = arr[mid - 1];
            }
            int next = Integer.MIN_VALUE;
            if (mid < arr.length - 1) {
                next = arr[mid + 1];
            }

            if (arr[mid] > pre && arr[mid] > next) {
                return mid;
            } else if (arr[mid] < pre) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
