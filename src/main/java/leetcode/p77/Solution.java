package leetcode.p77;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>(k);
        for (int i = 1; i <= n; i++) {
            path.add(i);
            perm(n, k, i, path, res);
            path.remove(path.size() - 1);
        }
        return res;
    }

    private void perm(int n, int k, int cur, ArrayList<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = cur + 1; i <= n; i++) {
            path.add(i);
            perm(n, k, i, path, res);
            path.remove(path.size() - 1);
        }
    }
}
