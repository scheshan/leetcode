package leetcode.p114;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public class State {
        TreeNode tail;
    }

    public void flatten(TreeNode root) {
        State state = new State();
        dfs(root, state);
    }

    private void dfs(TreeNode node, State state) {
        if (node == null) {
            return;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        node.right = null;

        if (state.tail != null) {
            state.tail.right = node;
        }
        state.tail = node;

        dfs(left, state);
        dfs(right, state);
    }
}
