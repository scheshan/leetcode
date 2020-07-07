package l1428;

import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/7/7
 */
public class Solution {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int rows = list.get(0);
        int cols = list.get(1);

        int res = -1;

        int i = 0;
        int j = cols - 1;

        while (i < rows && j >= 0) {
            int v = binaryMatrix.get(i, j);
            if (v == 1) {
                res = j;
                j--;
            } else {
                i++;
            }
        }

        return res;
    }
}
