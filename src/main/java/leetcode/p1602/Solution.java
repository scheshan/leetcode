package leetcode.p1602;

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

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        return dfs(root, u, new ArrayList<>(), 1);
    }

    private TreeNode dfs(TreeNode node, TreeNode u, List<TreeNode> list, int level) {
        if (node == null) {
            return null;
        }

        if (node == u) {
            if (list.size() >= level) {
                return list.get(level - 1);
            }
            return null;
        }

        if (list.size() < level) {
            list.add(node);
        } else {
            list.set(level - 1, node);
        }

        TreeNode res = dfs(node.right, u, list, level + 1);
        if (res == null) {
            res = dfs(node.left, u, list, level + 1);
        }
        return res;
    }
}
