package leetcode.p2586;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/7
 */
public class Solution {

    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;

        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                res++;
            }
        }

        return res;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u';
    }
}
