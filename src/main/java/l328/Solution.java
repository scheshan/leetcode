package l328;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddHead = null, oddTail = null, evenHead = null, evenTail = null;

        int i = 1;
        while (head != null) {
            if ((i & 1) == 0) {
                if (evenHead == null) {
                    evenHead = head;
                    evenTail = head;
                } else {
                    evenTail.next = head;
                    evenTail = head;
                }
            } else {
                if (oddHead == null) {
                    oddHead = head;
                    oddTail = head;
                } else {
                    oddTail.next = head;
                    oddTail = head;
                }
            }

            head = head.next;
            i++;
        }

        oddTail.next = evenHead;
        if (evenTail != null) {
            evenTail.next = null;
        }

        return oddHead;
    }
}
