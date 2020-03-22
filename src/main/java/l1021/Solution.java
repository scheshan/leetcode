package l1021;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public String removeOuterParentheses(String S) {
        int left = 0;

        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            sb.append(ch);
            if (ch == ')') {
                left--;
            } else {
                left++;
            }

            if (left == 0) {
                if (sb.length() > 2) {
                    res.append(sb.subSequence(1, sb.length() - 1));
                }
                sb.delete(0, sb.length());
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        new Solution().removeOuterParentheses("(()())(())");
    }
}
