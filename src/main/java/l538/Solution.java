package l538;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);

        sum += root.val;
        root.val = sum;

        convertBST(root.left);

        return root;
    }
}
