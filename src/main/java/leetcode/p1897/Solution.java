package leetcode.p1897;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public boolean makeEqual(String[] words) {
        int[] cnt = new int[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                cnt[word.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % words.length > 0) {
                return false;
            }
        }
        return true;
    }
}
