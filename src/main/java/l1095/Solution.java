package l1095;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/29
 */
public class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;

        while (left < right) {
            int mid = left + ((right - left) >>> 1);

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int top = left;

        left = 0;
        right = top;
        while (left < right) {
            int mid = (left + right) >> 1;
            int n = mountainArr.get(mid);
            if (n == target) {
                return mid;
            } else if (n < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        left = top;
        right = mountainArr.length();
        while (left < right) {
            int mid = (left + right) >> 1;
            int n = mountainArr.get(mid);
            if (n == target) {
                return mid;
            } else if (n > target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }
}
