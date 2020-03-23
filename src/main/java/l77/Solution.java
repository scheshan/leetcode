package l77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();

        perm(res, new LinkedList<>(), -1, n, k);

        return res;
    }

    private void perm(List<List<Integer>> res, LinkedList<Integer> list, int i, int n, int k) {
        if (i >= 0) {
            list.add(i + 1);
        }

        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }

        for (int j = i + 1; j < n; j++) {
            perm(res, list, j, n, k);
        }

        if (i >= 0) {
            list.removeLast();
        }
    }
}
