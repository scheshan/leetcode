package m04_06;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    private TreeNode prev = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        TreeNode target = inorderSuccessor(root.left, p);
        if (target != null) {
            return target;
        }

        if (prev != null && prev.val == p.val){
            return root;
        }

        prev = root;
        return inorderSuccessor(root.right, p);
    }
}
