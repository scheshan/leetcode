package l14;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        if (strs.length == 0) {
            return res.toString();
        }

        for (int i = 0; i < strs[0].length(); i++) {
            res.append(strs[0].charAt(i));

            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (i >= str.length() || str.charAt(i) != res.charAt(i)) {
                    res.deleteCharAt(res.length() - 1);
                    return res.toString();
                }
            }
        }

        return res.toString();
    }
}
