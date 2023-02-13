package leetcode.p168;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public String convertToTitle(int columnNumber) {
        List<Character> list = new ArrayList<>();
        while (columnNumber > 0) {
            list.add((char) ('A' + ((columnNumber - 1) % 26)));
            columnNumber = (columnNumber - 1) / 26;
        }

        char[] res = new char[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(res.length - i - 1);
        }
        return new String(res);
    }
}
