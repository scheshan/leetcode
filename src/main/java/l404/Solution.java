package l404;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }

        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
