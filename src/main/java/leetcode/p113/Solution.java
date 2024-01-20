package leetcode.p113;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, new LinkedList<>(), targetSum);

        return res;
    }

    private void dfs(TreeNode node, List<List<Integer>> res, Deque<Integer> path, int targetSum) {
        if (node == null) {
            return;
        }

        path.addLast(node.val);

        if (node.left == null && node.right == null) {
            if (node.val == targetSum) {
                res.add(new ArrayList<>(path));
            }
        } else {
            dfs(node.left, res, path, targetSum - node.val);
            dfs(node.right, res, path, targetSum - node.val);
        }

        path.removeLast();
    }
}
