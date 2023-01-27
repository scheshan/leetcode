package leetcode.p852;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (mid == 0 && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid == arr.length - 1 && arr[mid] > arr[mid - 1]) {
                return mid;
            }
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (arr[mid] > arr[mid - 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}
