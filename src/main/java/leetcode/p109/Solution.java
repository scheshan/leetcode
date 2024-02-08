package leetcode.p109;

import common.ListNode;
import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/8
 */
public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;

        TreeNode res = new TreeNode(slow.val);
        res.left = sortedListToBST(head);
        res.right = sortedListToBST(slow.next);

        return res;
    }
}
