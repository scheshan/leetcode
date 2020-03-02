package l206;

import shared.ListNode;

/**
 * 反转链表
 * <p>
 * before: 1->2->3->4->5
 * <p>
 * after:  5->4->3->2->1
 * <p>
 * 用遍历的解法，就是首先记录已经访问过的头节点，每遍历一个元素，将该元素的next指向已经访问过的元素的头节点。
 *
 * @author heshan
 * @date 2020/3/2
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        return traversal(head);
    }

    private ListNode traversal(ListNode head) {
        ListNode prev = null;
        ListNode next = head;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
        }

        return prev;
    }
}