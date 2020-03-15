package l572;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (check(s, t)) {
            return true;
        }
        if (!(s != null && t != null)) {
            return false;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else {
            if (s.val != t.val) {
                return false;
            }

            return check(s.left, t.left) && check(s.right, t.right);
        }
    }
}
