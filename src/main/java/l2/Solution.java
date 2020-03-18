package l2;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    private boolean b;

    private ListNode head;

    private ListNode tail;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            newNode(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            newNode(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            newNode(l2.val);
            l2 = l2.next;
        }

        if (b) {
            newNode(0);
        }

        return head;
    }

    private void newNode(int v) {
        if (b) {
            v++;
        }
        if (v >= 10) {
            b = true;
            v = v - 10;
        } else {
            b = false;
        }

        ListNode node = new ListNode(v);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
}
