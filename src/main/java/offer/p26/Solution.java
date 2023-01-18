package offer.p26;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        if (A != null && B != null) {
            if (A.val == B.val) {
                return dfs(A.left, B.left) && dfs(A.right, B.right);
            }
        }
        return B == null;
    }
}
