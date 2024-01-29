package leetcode.p1657;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] c1 = new int[26], c2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            c1[word1.charAt(i) - 'a']++;
            c2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] > 0 && c2[i] > 0) {
                continue;
            }
            if (c1[i] == 0 && c2[i] == 0) {
                continue;
            }
            return false;
        }

        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
