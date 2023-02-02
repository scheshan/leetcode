package leetcode.p1078;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public String[] findOcurrences(String text, String first, String second) {
        String p1 = null;
        String p2 = null;

        List<String> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (r < text.length()) {
            while (r < text.length() && text.charAt(r) != ' ') {
                r++;
            }
            String cur = text.substring(l, r);
            if (first.equals(p1) && second.equals(p2)) {
                list.add(cur);
            }
            p1 = p2;
            p2 = cur;

            r++;
            l = r;
        }

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
