package l563;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    int tilt = 0;

    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
