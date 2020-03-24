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

        boolean match = true;
        for (int i = 0; match; i++) {
            char ch = ' ';
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    match = false;
                    break;
                }
                if (j == 0) {
                    ch = strs[j].charAt(i);
                } else {
                    if (strs[j].charAt(i) != ch) {
                        match = false;
                        break;
                    }
                }
            }
            if (match) {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
