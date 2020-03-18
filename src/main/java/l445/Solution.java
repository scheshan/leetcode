package l445;

import shared.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    private boolean b = false;

    private Deque<ListNode> deque = new LinkedList<>();

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> d1 = new LinkedList<>();
        Deque<ListNode> d2 = new LinkedList<>();

        while (l1 != null) {
            d1.addFirst(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            d2.addFirst(l2);
            l2 = l2.next;
        }

        while ((!d1.isEmpty()) && (!d2.isEmpty())) {
            newNode(d1.remove().val + d2.remove().val);
        }
        while (!d1.isEmpty()) {
            newNode(d1.remove().val);
        }
        while (!d2.isEmpty()) {
            newNode(d2.remove().val);
        }
        if (b) {
            newNode(0);
        }

        ListNode head = null;
        ListNode tail = null;
        while (!deque.isEmpty()) {
            ListNode node = deque.removeFirst();
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
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
        deque.addFirst(node);
    }
}
