package leetcode.p520;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public boolean detectCapitalUse(String word) {
        int upper = 0;
        int lower = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                lower++;
            } else {
                upper++;
            }
        }

        return upper == 0 || lower == 0 || (upper == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
    }
}
