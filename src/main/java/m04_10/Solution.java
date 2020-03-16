package m04_10;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
public class Solution {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }

        return isSame(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 != null && t2 != null) {
            if (t1.val != t2.val) {
                return false;
            }

            return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
        } else {
            return false;
        }
    }
}
