package leetcode.p366;

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

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            if (dfs(root, list)) {
                root = null;
            }
            res.add(list);
        }
        return res;
    }

    private boolean dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return true;
        }

        if (dfs(root.left, list)) {
            root.left = null;
        }
        if (dfs(root.right, list)) {
            root.right = null;
        }
        return false;
    }
}
