package leetcode.p2485;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public int pivotInteger(int n) {
        int l = 1;
        int r = n + 1;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int left = ((1 + mid) * mid) >> 1;
            int right = ((mid + n) * (n - mid + 1)) >> 1;
            if (left == right) {
                return mid;
            } else if (left < right) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}
