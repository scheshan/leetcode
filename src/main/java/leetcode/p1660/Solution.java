package leetcode.p1660;

import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    public TreeNode correctBinaryTree(TreeNode root) {
        return dfs(root, new HashSet<>());
    }

    private TreeNode dfs(TreeNode node, Set<TreeNode> visit) {
        if (node == null) {
            return null;
        }

        if (node.right != null && visit.contains(node.right)) {
            return null;
        }

        visit.add(node);
        node.right = dfs(node.right, visit);
        node.left = dfs(node.left, visit);
        return node;
    }
}
