package leetcode.p2108;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int l = 0;
        int r = word.length() - 1;

        while (l < r) {
            if (word.charAt(l++) != word.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
