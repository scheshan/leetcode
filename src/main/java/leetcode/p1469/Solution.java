package leetcode.p1469;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        travel(root, null, res);

        return res;
    }

    private void travel(TreeNode node, TreeNode parent, List<Integer> res) {
        if (node == null) {
            return;
        }

        travel(node.left, node, res);
        travel(node.right, node, res);

        if (parent == null || (parent.left != null && parent.right != null)) {
            return;
        }

        res.add(node.val);
    }
}
