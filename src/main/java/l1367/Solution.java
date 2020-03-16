package l1367;

import shared.ListNode;
import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
public class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (match(head, root)) {
            return true;
        }

        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean match(ListNode cur, TreeNode root) {
        if (cur == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != cur.val) {
            return false;
        }
        cur = cur.next;
        return match(cur, root.left) || match(cur, root.right);
    }
}
