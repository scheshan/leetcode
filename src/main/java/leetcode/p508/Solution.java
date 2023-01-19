package leetcode.p508;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    int max;

    List<Integer> list = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left, map);
        int right = dfs(node.right, map);

        int sum = left + right + node.val;
        int count = map.compute(sum, (k, v) -> {
            if (v == null) {
                v = 0;
            }
            return ++v;
        });

        if (count > max) {
            max = count;
            list.clear();
            list.add(sum);
        } else if (count == max) {
            list.add(sum);
        }
        return sum;
    }
}
