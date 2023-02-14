package leetcode.p2299;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }

        int low = 0, high = 0, numeric = 0, special = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                low++;
            } else if (ch >= 'A' && ch <= 'Z') {
                high++;
            } else if (ch >= '0' && ch <= '9') {
                numeric++;
            } else {
                special++;
            }

            if (i > 0 && ch == password.charAt(i - 1)) {
                return false;
            }
        }
        return low > 0 && high > 0 && numeric > 0 && special > 0;
    }
}
