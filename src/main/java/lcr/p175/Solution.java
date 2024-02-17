package lcr.p175;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public int calculateDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(calculateDepth(root.left), calculateDepth(root.right)) + 1;
    }
}
