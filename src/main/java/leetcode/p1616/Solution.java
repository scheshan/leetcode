package leetcode.p1616;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/18
 */
public class Solution {

    public boolean checkPalindromeFormation(String a, String b) {
        return valid(a, b) || valid(b, a);
    }

    private boolean valid(String s1, String s2) {
        int l = 0;
        int r = s1.length() - 1;
        while (l < r && s1.charAt(l) == s2.charAt(r)) {
            l++;
            r--;
        }
        if (l >= r) {
            return true;
        }

        return validString(s1, l, r) || validString(s2, l, r);
    }

    private boolean validString(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
