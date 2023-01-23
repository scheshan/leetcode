package leetcode.p1662;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int l = 0;
        int ind1 = 0;
        int r = 0;
        int ind2 = 0;

        while (l < word1.length && ind1 < word1[l].length() && r < word2.length && ind2 < word2[r].length()) {
            if (word1[l].charAt(ind1) != word2[r].charAt(ind2)) {
                return false;
            }
            ind1++;
            if (ind1 == word1[l].length()) {
                l++;
                ind1 = 0;
            }
            ind2++;
            if (ind2 == word2[r].length()) {
                r++;
                ind2 = 0;
            }
        }

        return l == word1.length && r == word2.length;
    }
}
