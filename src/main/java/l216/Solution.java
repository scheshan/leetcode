package l216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/2
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();

        perm(res, new LinkedList<>(), n, k, 1);

        return res;
    }

    private void perm(List<List<Integer>> res, LinkedList<Integer> path, int n, int k, int cur) {
        if (path.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = cur; i <= 9; i++) {
            path.addLast(i);

            perm(res, path, n - i, k, i + 1);

            path.removeLast();
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum3(3, 15);
    }
}
