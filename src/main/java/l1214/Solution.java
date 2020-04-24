package l1214;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) {
            return false;
        }

        return find(root2, target - root1.val) || twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }

    private boolean find(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        if (node.val == target) {
            return true;
        } else if (node.val < target) {
            return find(node.right, target);
        } else {
            return find(node.left, target);
        }
    }
}
