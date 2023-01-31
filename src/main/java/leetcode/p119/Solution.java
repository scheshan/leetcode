package leetcode.p119;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        int row = 1;

        List<Integer> pre = null;
        while (row <= rowIndex + 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                if (i == 0 || i == row - 1) {
                    list.add(1);
                } else {
                    list.add(pre.get(i - 1) + pre.get(i));
                }
            }
            pre = list;
            row++;
        }
        return pre;
    }
}
