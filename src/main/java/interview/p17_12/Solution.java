package interview.p17_12;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    private class State {
        TreeNode head;
        TreeNode tail;
    }

    public TreeNode convertBiNode(TreeNode root) {
        State state = new State();
        state.head = new TreeNode(0);
        state.tail = state.head;

        dfs(root, state);

        return state.head.right;
    }

    private void dfs(TreeNode node, State state) {
        if (node == null) {
            return;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        node.right = null;

        dfs(left, state);

        state.tail.right = node;
        state.tail = node;

        dfs(right, state);
    }
}
