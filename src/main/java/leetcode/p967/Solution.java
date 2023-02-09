package leetcode.p967;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/9
 */
public class Solution {

    public int[] numsSameConsecDiff(int n, int k) {
        int min = (int) Math.pow(10, n - 1);
        int max = (int) Math.pow(10, n);

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            backtrack(min, max, i, k, list);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void backtrack(int min, int max, int cur, int k, List<Integer> res) {
        if (cur >= min) {
            if (cur < max) {
                res.add(cur);
            }
            return;
        }

        int lastNumber = cur % 10;
        if (lastNumber - k >= 0) {
            backtrack(min, max, cur * 10 + lastNumber - k, k, res);
        }
        if (k != 0 && lastNumber + k < 10) {
            backtrack(min, max, cur * 10 + lastNumber + k, k, res);
        }
    }
}
