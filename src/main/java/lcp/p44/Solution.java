package lcp.p44;

import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int numColor(TreeNode root) {
        Set<Integer> color = new HashSet<>();
        dfs(root, color);

        return color.size();
    }

    private void dfs(TreeNode node, Set<Integer> color) {
        if (node == null) {
            return;
        }

        color.add(node.val);
        dfs(node.left, color);
        dfs(node.right, color);
    }
}
