package l856;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/3
 */
public class Solution {

    private int index = 0;

    public int scoreOfParentheses(String S) {
        int res = 0;

        while (index < S.length()) {
            res += readSingle(S);
        }

        return res;
    }

    private int readSingle(String S) {
        index++;

        int res = 0;
        while (S.charAt(index) != ')') {
            res += readSingle(S);
        }

        index++;

        return Math.max(2 * res, 1);
    }
}
