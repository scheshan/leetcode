package leetcode.p2194;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();

        char c1 = s.charAt(0);
        char c2 = s.charAt(3);
        int n1 = s.charAt(1) - '0';
        int n2 = s.charAt(4) - '0';

        for (char ch = c1; ch <= c2; ch++) {
            for (int num = n1; num <= n2; num++) {
                res.add(ch + String.valueOf(num));
            }
        }
        return res;
    }
}
