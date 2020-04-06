package l25;

import shared.ListNode;
import shared.Wrapper;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/6
 */
public class Solution {

    private ListNode dummy = new ListNode(0);

    private ListNode tail = dummy;

    private ListNode nextHead = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        if (head == null) {
            return head;
        }

        nextHead = head;
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            i++;

            ListNode n = cur;
            cur = cur.next;

            if (i % k == 0) {
                ListNode tmp = nextHead;
                nextHead = n.next;
                n.next = null;

                reverse(tmp);
            }
        }

        if (i % k != 0) {
            tail.next = nextHead;
        }

        return dummy.next;
    }

    private void reverse(ListNode node) {
        if (node == null) {
            return;
        }

        reverse(node.next);

        tail.next = node;
        node.next = null;
        tail = tail.next;
    }

    public static void main(String[] args) {
        ListNode head = Wrapper.stringToListNode("[1,2,3,4,5]");
        new Solution().reverseKGroup(head, 2);
    }
}
