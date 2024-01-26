package leetcode.p118;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = null;

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);

            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    row.add(1);
                } else {
                    row.add(pre.get(j) + pre.get(j - 1));
                }
            }

            res.add(row);
            pre = row;
        }

        return res;
    }
}
