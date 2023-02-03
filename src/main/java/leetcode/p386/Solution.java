package leetcode.p386;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);

        for (int i = 1; i < 10; i++) {
            dfs(n, i, res);
        }
        return res;
    }

    private void dfs(int max, int cur, List<Integer> res) {
        if (cur > max) {
            return;
        }

        res.add(cur);

        for (int i = 0; i < 10; i++) {
            dfs(max, cur * 10 + i, res);
        }
    }
}
