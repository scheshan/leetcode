package leetcode.p1935;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] map = new boolean[26];
        for (int i = 0; i < brokenLetters.length(); i++) {
            map[brokenLetters.charAt(i) - 'a'] = true;
        }

        int res = 0;
        int r = 0;
        while (r < text.length()) {
            boolean match = false;
            while (r < text.length() && text.charAt(r) != ' ') {
                if (map[text.charAt(r) - 'a']) {
                    match = true;
                }
                r++;
            }
            if (!match) {
                res++;
            }
            r++;
        }
        return res;
    }
}
