package leetcode.p278;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/24
 */
public class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int res = 0;
        int l = 1;
        int r = n;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (isBadVersion(mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
