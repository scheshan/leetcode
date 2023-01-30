package leetcode.p662;

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

    public int widthOfBinaryTree(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        dfs(root, 0, 1, list);

        int res = 0;
        for (int[] arr : list) {
            res = Math.max(res, arr[1] - arr[0] + 1);
        }
        return res;
    }

    private void dfs(TreeNode node, int ind, int level, List<int[]> list) {
        if (node == null) {
            return;
        }

        if (list.size() < level) {
            list.add(new int[]{ind, ind});
        } else {
            list.get(level - 1)[1] = ind;
        }

        dfs(node.left, (ind << 1) + 1, level + 1, list);
        dfs(node.right, (ind << 1) + 2, level + 1, list);
    }
}
