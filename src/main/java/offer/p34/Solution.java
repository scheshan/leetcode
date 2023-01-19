package offer.p34;

import common.TreeNode;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(root, target, path, res);

        return res;
    }

    private void dfs(TreeNode node, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                List<Integer> list = new ArrayList<>();
                list.addAll(path);
                res.add(list);
            }
        } else {
            dfs(node.left, target - node.val, path, res);
            dfs(node.right, target - node.val, path, res);
        }

        path.removeLast();
    }
}
