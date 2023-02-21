package leetcode.p1557;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/21
 */
public class Solution {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] in = new int[n];
        int size = n;
        for (List<Integer> edge : edges) {
            in[edge.get(1)]++;
            if (in[edge.get(1)] == 1) {
                size--;
            }
        }

        List<Integer> res = new ArrayList<>(size);
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
