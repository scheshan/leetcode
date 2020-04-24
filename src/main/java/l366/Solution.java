package l366;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);

        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int level = Math.max(left, right) + 1;
        if (level > res.size()) {
            res.add(new LinkedList<>());
        }

        res.get(level - 1).add(root.val);
        return level;
    }
}
