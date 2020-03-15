package l671;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    public int findSecondMinimumValue(TreeNode root) {
        int result = findGreater(root, root.val);
        if (result == root.val) {
            return -1;
        }
        return result;
    }

    private int findGreater(TreeNode node, int n) {
        if (node == null) {
            return n;
        }

        if (node.val > n) {
            return node.val;
        }

        int left = findGreater(node.left, n);
        int right = findGreater(node.right, n);

        if (left == n && right == n) {
            return n;
        } else if (left > n && right > n) {
            return Math.min(left, right);
        } else {
            return Math.max(left, right);
        }
    }
}
