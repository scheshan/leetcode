package l118;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/29
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            row.add(1);

            if (i > 0) {
                for (int j = 1; j <= i - 1; j++) {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
                row.add(1);
            }

            res.add(row);
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().generate(5);
    }
}
