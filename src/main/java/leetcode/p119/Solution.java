package leetcode.p119;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            res.add(0);
        }

        for (int row = 0; row <= rowIndex; row++) {
            for (int col = row; col >= 0; col--) {
                if (col == row || col == 0) {
                    res.set(col, 1);
                } else {
                    res.set(col, res.get(col) + res.get(col - 1));
                }
            }
        }

        return res;
    }
}
