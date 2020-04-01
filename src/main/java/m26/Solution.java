package m26;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        } else if (A == null || B == null) {
            return false;
        } else {
            if (match(A, B)) {
                return true;
            } else {
                return isSubStructure(A.left, B) || isSubStructure(A.right, B);
            }
        }
    }

    private boolean match(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return match(A.left, B.left) && match(A.right, B.right);
    }
}
