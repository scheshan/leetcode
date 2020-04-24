package l369;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public ListNode plusOne(ListNode head) {
        boolean flag = add(head);

        if (flag) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    private boolean add(ListNode node) {
        boolean flag = false;
        if (node.next != null) {
            flag = add(node.next);
        } else {
            node.val++;
        }
        if (flag) {
            node.val++;
            flag = false;
        }
        if (node.val >= 10) {
            node.val -= 10;
            flag = true;
        }

        return flag;
    }
}
