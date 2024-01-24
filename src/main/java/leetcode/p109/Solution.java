package leetcode.p109;

import common.ListNode;
import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode left = head;
        ListNode mid = split(left);
        ListNode right = mid.next;

        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(left);
        root.right = sortedListToBST(right);

        return root;
    }

    private ListNode split(ListNode head) {
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre != null) {
            pre.next = null;
        }

        return slow;
    }
}
