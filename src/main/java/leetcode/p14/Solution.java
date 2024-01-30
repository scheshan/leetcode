package leetcode.p14;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        int res = 0;

        for (int ind = 0; ind < strs[0].length(); ind++) {
            char ch = strs[0].charAt(ind);
            boolean match = true;

            for (int i = 1; i < strs.length; i++) {
                if (ind >= strs[i].length() || strs[i].charAt(ind) != ch) {
                    match = false;
                    break;
                }
            }

            if (match) {
                res = ind + 1;
            } else {
                break;
            }
        }

        return strs[0].substring(0, res);
    }
}
