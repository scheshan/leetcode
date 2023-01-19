package leetcode.p14;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder(strs[0].length());

        for (int i = 0; i < strs[0].length(); i++) {
            boolean match = true;
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (!match) {
                break;
            }
            sb.append(ch);
        }

        return sb.toString();
    }
}
