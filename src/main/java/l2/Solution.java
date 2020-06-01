package l2;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    private ListNode head = new ListNode(0);

    private ListNode tail = head;

    private boolean flag = false;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            addNode(l1, l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            addNode(l1, l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            addNode(l2, l2.val);
            l2 = l2.next;
        }

        if (flag) {
            addNode(new ListNode(0), 0);
        }

        return head.next;
    }

    private void addNode(ListNode node, int v) {
        if (flag) {
            v++;
        }

        flag = false;
        if (v >= 10) {
            v -= 10;
            flag = true;
        }

        node.val = v;
        tail.next = node;
        tail = node;
    }
}
