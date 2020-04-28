package l1237;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/29
 */
public class Solution {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new LinkedList<>();

        for (int x = 1; x <= z; x++) {
            int left = 1;
            int right = 1000;

            while (left <= right) {
                int mid = (left + right) >> 1;

                int n = customfunction.f(x, mid);
                if (n == z) {
                    res.add(Arrays.asList(x, mid));
                    break;
                } else if (n < z) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return res;
    }
}
