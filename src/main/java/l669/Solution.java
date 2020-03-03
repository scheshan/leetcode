package l669;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        if (root.val < L) {
            return root.right;
        } else if (root.val > R) {
            return root.left;
        }
        return root;
    }
}
