package leetcode.p1469;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, null, res);
        return res;
    }

    private void dfs(TreeNode node, TreeNode parent, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (parent != null && (parent.left == null || parent.right == null)) {
            list.add(node.val);
        }
        dfs(node.left, node, list);
        dfs(node.right, node, list);
    }
}
