package leetcode.p1249;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/13
 */
public class Solution {

    public String minRemoveToMakeValid(String s) {
        int right = 0;
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                right++;
            }
        }

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
                if (left <= right) {
                    sb.append(s.charAt(i));
                }
            } else if (s.charAt(i) == ')') {
                right--;
                if (left > 0) {
                    left--;
                    sb.append(s.charAt(i));
                }
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
