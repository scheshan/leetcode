package interview.p17_11;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/12
 */
public class Solution {

    public int findClosest(String[] words, String word1, String word2) {
        int ind1 = -1;
        int ind2 = -1;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                ind1 = i;
            } else if (words[i].equals(word2)) {
                ind2 = i;
            }

            if (ind1 >= 0 && ind2 >= 0) {
                res = Math.min(res, Math.abs(ind1 - ind2));
            }
        }
        return res;
    }
}
