package leetcode.p1161;

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

    public int maxLevelSum(TreeNode root) {
        List<Integer> sum = new ArrayList<>();
        dfs(root, 1, sum);

        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < sum.size(); i++) {
            if (sum.get(i) > max) {
                max = sum.get(i);
                res = i;
            }
        }
        return res + 1;
    }

    private void dfs(TreeNode node, int level, List<Integer> sum) {
        if (node == null) {
            return;
        }
        if (sum.size() < level) {
            sum.add(0);
        }

        sum.set(level - 1, sum.get(level - 1) + node.val);
        dfs(node.left, level + 1, sum);
        dfs(node.right, level + 1, sum);
    }
}
