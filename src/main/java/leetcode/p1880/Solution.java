package leetcode.p1880;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return toNumber(firstWord) + toNumber(secondWord) == toNumber(targetWord);
    }

    private int toNumber(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = res * 10 + str.charAt(i) - 'a';
        }
        return res;
    }
}
