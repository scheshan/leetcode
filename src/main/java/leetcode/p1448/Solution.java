package leetcode.p1448;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    private int res;

    public int goodNodes(TreeNode root) {
        travel(root, root.val);
        return res;
    }

    private void travel(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            res++;
            max = root.val;
        }

        travel(root.left, max);
        travel(root.right, max);
    }
}
