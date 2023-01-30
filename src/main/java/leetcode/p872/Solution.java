package leetcode.p872;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        dfs(root1, l1);

        List<Integer> l2 = new ArrayList<>();
        dfs(root2, l2);

        return l1.equals(l2);
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.val);
        } else {
            dfs(node.left, list);
            dfs(node.right, list);
        }
    }
}
