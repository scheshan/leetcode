package l633;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            int n = left * left + right * right;
            if (n > c) {
                right--;
            } else if (n < c) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}
