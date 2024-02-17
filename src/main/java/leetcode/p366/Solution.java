package leetcode.p366;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        travel(root, res);

        return res;
    }

    private int travel(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return 0;
        }

        int level = 0;
        level = Math.max(travel(node.left, res), travel(node.right, res));

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);

        return level + 1;
    }
}
