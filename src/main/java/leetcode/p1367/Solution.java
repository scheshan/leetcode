package leetcode.p1367;

import common.ListNode;
import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        return match(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean match(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (root.val != head.val) {
            return false;
        }
        return match(root.left, head.next) || match(root.right, head.next);
    }
}
