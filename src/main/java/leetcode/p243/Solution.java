package leetcode.p243;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int ind1 = -1, ind2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                ind1 = i;
                res = Math.min(res, count(ind1, ind2));
            } else if (wordsDict[i].equals(word2)) {
                ind2 = i;
                res = Math.min(res, count(ind2, ind1));
            }
        }
        return res;
    }

    private int count(int max, int min) {
        if (min < 0) {
            return Integer.MAX_VALUE;
        }
        return max - min;
    }
}
