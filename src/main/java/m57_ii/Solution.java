package m57_ii;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/15
 */
public class Solution {

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new LinkedList<>();

        int l = 1;
        int r = 2;

        while (l < r) {
            double sum = (l + r) * (r - l + 1) / 2.0;
            if (sum == target) {
                int[] item = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    item[i - l] = i;
                }
                list.add(item);
                l++;
                r++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }

        int[][] res = new int[list.size()][];
        int i = 0;
        for (int[] item : list) {
            res[i++] = item;
        }

        return res;
    }
}
