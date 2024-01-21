package leetcode.p6;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int ind = 0;
        while (ind < s.length()) {
            for (int i = 0; i < numRows && ind < s.length(); i++) {
                list.get(i).append(s.charAt(ind++));
            }

            for (int i = numRows - 2; i > 0 && ind < s.length(); i--) {
                list.get(i).append(s.charAt(ind++));
            }
        }

        StringBuilder res = new StringBuilder(s.length());
        for (StringBuilder sb : list) {
            res.append(sb.toString());
        }

        return res.toString();
    }
}
