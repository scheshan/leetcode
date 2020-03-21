package l1019;

import shared.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public int[] nextLargerNodes(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        Deque<Integer> deque = new LinkedList<>();

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ListNode node = list.get(i);

            while (!deque.isEmpty() && list.get(deque.peekLast()).val < node.val) {
                ans[deque.removeLast()] = node.val;
            }
            deque.addLast(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        new Solution().nextLargerNodes(head);
    }
}
