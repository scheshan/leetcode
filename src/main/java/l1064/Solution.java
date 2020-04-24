package l1064;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public int fixedPoint(int[] A) {
        int res = -1;

        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] == mid) {
                res = mid;
                right = mid;
            } else if (A[mid] < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
