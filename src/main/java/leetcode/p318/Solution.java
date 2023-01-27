package leetcode.p318;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int maxProduct(String[] words) {
        int[] hash = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int n = 0;
            for (int j = 0; j < word.length(); j++) {
                n |= (1 << (word.charAt(j) - 'a'));
            }
            hash[i] = n;
        }

        int res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((hash[i] & hash[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
