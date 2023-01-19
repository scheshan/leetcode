package leetcode.p199;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (res.size() == level) {
            res.add(node.val);
        }

        dfs(node.right, level + 1, res);
        dfs(node.left, level + 1, res);
    }
}
