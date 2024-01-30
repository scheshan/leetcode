package leetcode.p6;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int ind = 0;
        while (ind < s.length()) {
            for (int i = 0; i < list.size() && ind < s.length(); i++) {
                list.get(i).append(s.charAt(ind++));
            }

            for (int i = list.size() - 2; i >= 1 && ind < s.length(); i--) {
                list.get(i).append(s.charAt(ind++));
            }
        }

        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
