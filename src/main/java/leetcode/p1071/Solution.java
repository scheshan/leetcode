package leetcode.p1071;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public String gcdOfStrings(String str1, String str2) {
        for (int i = Math.min(str1.length(), str2.length()); i >= 1; i--) {
            String pattern = str1.substring(0, i);
            if (isValid(str1, pattern) && isValid(str2, pattern)) {
                return pattern;
            }
        }

        return "";
    }

    private boolean isValid(String str, String pattern) {
        if (str.length() % pattern.length() != 0) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != pattern.charAt(i % pattern.length())) {
                return false;
            }
        }

        return true;
    }
}
