package leetcode.p118;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        int row = 1;
        List<List<Integer>> res = new ArrayList<>(numRows);
        while (row <= numRows) {
            List<Integer> list = new ArrayList<>(row);
            for (int col = 0; col < row; col++) {
                if (col == 0 || col == row - 1) {
                    list.add(1);
                } else {
                    list.add(res.get(row - 2).get(col - 1) + res.get(row - 2).get(col));
                }
            }
            res.add(list);
            row++;
        }
        return res;
    }
}
