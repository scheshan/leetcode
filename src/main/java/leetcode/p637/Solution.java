package leetcode.p637;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        dfs(root, 1, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int level, List<Double> res, List<long[]> count) {
        if (node == null) {
            return;
        }

        if (res.size() < level) {
            res.add(0d);
            count.add(new long[2]);
        }

        long[] arr = count.get(level - 1);
        arr[0] += node.val;
        arr[1]++;
        res.set(level - 1, arr[0] * 1.0 / arr[1]);

        dfs(node.left, level + 1, res, count);
        dfs(node.right, level + 1, res, count);
    }
}
