package leetcode.p245;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/12
 */
public class Solution {

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int ind1 = -1;
        int ind2 = -1;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                ind1 = i;
                if (ind2 >= 0) {
                    res = Math.min(res, ind1 - ind2);
                }
            }
            if (word.equals(word2)) {
                ind2 = i;
                if (ind1 >= 0 && ind1 != ind2) {
                    res = Math.min(res, ind2 - ind1);
                }
            }
        }

        return res;
    }
}
