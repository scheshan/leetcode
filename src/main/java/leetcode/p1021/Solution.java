package leetcode.p1021;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public String removeOuterParentheses(String s) {
        char[] arr = new char[s.length()];
        int ind = 0;

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (left != 0) {
                    arr[ind++] = '(';
                }
                left++;
            } else {
                left--;
                if (left != 0) {
                    arr[ind++] = ')';
                }
            }
        }
        return new String(arr, 0, ind);
    }
}
