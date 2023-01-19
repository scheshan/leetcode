package leetcode.p9;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int m = 0;
        int n = x;

        while (n != 0) {
            m = m * 10 + n % 10;
            n /= 10;
        }

        return m == x;
    }
}
