package leetcode.p700;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode res = null;

        while (root != null) {
            if (root.val == val) {
                res = root;
                break;
            } else if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return res;
    }
}
