package leetcode.p1302;

import common.ListNode;
import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    private class State {
        int level;
        int cnt;
    }

    public int deepestLeavesSum(TreeNode root) {
        State state = new State();
        dfs(root, 1, state);

        return state.cnt;
    }

    private void dfs(TreeNode node, int level, State state) {
        if (node == null) {
            return;
        }

        if (level > state.level) {
            state.level = level;
            state.cnt = node.val;
        } else if (level == state.level) {
            state.cnt += node.val;
        }

        dfs(node.left, level + 1, state);
        dfs(node.right, level + 1, state);
    }
}
