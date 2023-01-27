package leetcode.p953;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        int[] ind = new int[26];
        for (int i = 0; i < order.length(); i++) {
            ind[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (!isSorted(words[i - 1], words[i], ind)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String s1, String s2, int[] ind) {
        int l = Math.min(s1.length(), s2.length());

        for (int i = 0; i < l; i++) {
            int ind1 = ind[s1.charAt(i) - 'a'];
            int ind2 = ind[s2.charAt(i) - 'a'];
            if (ind1 < ind2) {
                return true;
            } else if (ind1 > ind2) {
                return false;
            }
        }

        return s1.length() <= s2.length();
    }
}
