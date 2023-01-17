package leetcode.p700;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode pre = root;
        while (pre != null) {
            if (pre.val == val) {
                return pre;
            } else if (pre.val < val) {
                pre = pre.right;
            } else {
                pre = pre.left;
            }
        }
        return null;
    }
}
