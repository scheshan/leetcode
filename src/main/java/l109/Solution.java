package l109;

import shared.ListNode;
import shared.TreeNode;
import shared.Wrapper;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        ListNode mid = middle(head);
        if (mid == null) {
            return null;
        }

        TreeNode root = new TreeNode(mid.val);

        ListNode next = mid.next;
        mid.next = null;

        if (head != mid) {
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(next);

        return root;
    }

    private ListNode middle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = null;

        while (fast != null) {
            prev = slow;

            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = Wrapper.stringToListNode("[-10,-3,0,5,9]");
        TreeNode root = new Solution().sortedListToBST(head);
    }
}
