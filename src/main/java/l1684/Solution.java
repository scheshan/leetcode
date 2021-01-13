package l1684;

/**
 * Solution
 *
 * @author heshan
 * @date 2021/1/10
 */
public class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] map = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            map[allowed.charAt(i) - 'a'] = true;
        }

        int res = 0;
        for (String word : words) {
            boolean match = true;
            for (int i = 0; i < word.length(); i++) {
                if (!map[word.charAt(i) - 'a']) {
                    match = false;
                    break;
                }
            }
            if (match) {
                res++;
            }
        }
        return res;
    }
}
