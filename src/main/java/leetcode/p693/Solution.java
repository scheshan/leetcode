package leetcode.p693;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public boolean hasAlternatingBits(int n) {
        return valid(n, 1) || valid(n, 0);
    }

    private boolean valid(int n, int start) {
        while (n != 0) {
            if ((n & 1) != start) {
                return false;
            }
            n >>= 1;
            start = 1 - start;
        }
        return true;
    }
}
