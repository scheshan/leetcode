package leetcode.p1214;

import common.TreeNode;

/**
 * Solutiuon
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) {
            return false;
        }

        int delta = target - root1.val;
        TreeNode node = root2;
        while (node != null) {
            if (node.val == delta) {
                return true;
            } else if (node.val < delta) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }
}
