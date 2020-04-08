package l9;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/8
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int n = x;
        int y = 0;

        while (n != 0) {
            y = y * 10 + n % 10;
            n /= 10;
        }

        return x == y;
    }
}
