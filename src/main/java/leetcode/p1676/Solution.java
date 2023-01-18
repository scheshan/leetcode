package leetcode.p1676;

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null) {
            return null;
        }

        if (find(root, nodes)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);

        if (left == null && right == null) {
            return null;
        } else if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }

    private boolean find(TreeNode root, TreeNode[] nodes) {
        for (TreeNode node : nodes) {
            if (root == node) {
                return true;
            }
        }
        return false;
    }
}
