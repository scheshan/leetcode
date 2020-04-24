package l243;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;

        int w1 = -1;
        int w2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                w1 = i;

                if (w1 >= 0 && w2 >= 0) {
                    res = Math.min(res, Math.abs(w1 - w2));
                }
            } else if (words[i].equals(word2)) {
                w2 = i;

                if (w1 >= 0 && w2 >= 0) {
                    res = Math.min(res, Math.abs(w1 - w2));
                }
            }
        }
        return res;
    }
}
