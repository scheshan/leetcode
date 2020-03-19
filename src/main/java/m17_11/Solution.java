package m17_11;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public int findClosest(String[] words, String word1, String word2) {
        int result = 0;

        int l = -1;
        int r = -1;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                l = i;
                result = compute(l, r, result);
            } else if (word.equals(word2)) {
                r = i;
                result = compute(l, r, result);
            }
        }

        return result;
    }

    private int compute(int l, int r, int result) {
        if (l < 0 || r < 0) {
            return result;
        }

        int n = Math.abs(l - r);
        if (result == 0) {
            return n;
        }
        return Math.min(result, n);
    }
}
