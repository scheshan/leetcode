package l367;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            int n = num / mid;
            int d = num % mid;

            if (mid == n) {
                if (d == 0) {
                    return true;
                }
                right = mid;
            } else if (mid < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean res = new Solution().isPerfectSquare(2147395600);
        System.out.println(res);
    }
}
