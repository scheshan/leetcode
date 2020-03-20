package l234;

import shared.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/20
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        Deque<ListNode> deque = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            deque.addFirst(node);
            node = node.next;
        }

        ListNode left = head;
        while (left != null) {
            ListNode right = deque.remove();

            if (left == right) {
                return true;
            }
            if (left.val != right.val) {
                return false;
            }

            left = left.next;
        }

        return true;
    }
}
