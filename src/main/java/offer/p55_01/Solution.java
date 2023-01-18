package offer.p55_01;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = Math.max(maxDepth(root.left), maxDepth(root.right));
        return res + 1;
    }
}
