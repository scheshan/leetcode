package leetcode.p9;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);

        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
