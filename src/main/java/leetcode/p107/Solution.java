package leetcode.p107;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);

        int l = 0;
        int r = res.size() - 1;
        while (l < r) {
            List<Integer> tmp = res.get(l);
            res.set(l, res.get(r));
            res.set(r, tmp);
            l++;
            r--;
        }
        return res;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }
}
