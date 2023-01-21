package leetcode.p2068;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] cnt = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            cnt[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            cnt[word2.charAt(i) - 'a']--;
        }

        for (int c : cnt) {
            if (c > 3 || c < -3) {
                return false;
            }
        }
        return true;
    }
}
