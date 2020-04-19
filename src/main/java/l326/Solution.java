package l326;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public boolean isPowerOfThree(int n) {
        int cur = 1;

        while (cur > 0 && cur <= n) {
            if (cur == n) {
                return true;
            }
            cur *= 3;
        }

        return false;
    }
}
