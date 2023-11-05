package leetcode.p14;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/5
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int ind = 0;

        while (ind < strs[0].length()) {
            boolean match = true;

            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if (ind >= str.length() || str.charAt(ind) != strs[0].charAt(ind)) {
                    match = false;
                    break;
                }
            }

            if (!match) {
                break;
            }
            ind++;
        }

        if (ind == 0) {
            return "";
        }
        return strs[0].substring(0, ind);
    }
}
