package leetcode.p1237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/18
 */
public class Solution {

    interface CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        int f(int x, int y);
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int x = 1, y = 1000; x <= 1000 && y >= 1; x++) {
            while (y >= 1 && customfunction.f(x, y) > z) {
                y--;
            }
            if (y >= 1 && customfunction.f(x, y) == z) {
                res.add(Arrays.asList(x, y));
            }
        }
        return res;
    }
}
