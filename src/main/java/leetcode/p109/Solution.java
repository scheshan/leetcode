package leetcode.p109;

import common.ListNode;
import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode pre = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre != null) {
            pre.next = null;
        }

        TreeNode tree = new TreeNode(slow.val);
        if (head != slow) {
            tree.left = sortedListToBST(head);
            tree.right = sortedListToBST(slow.next);
        }

        return tree;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        new Solution().sortedListToBST(head);
    }
}
