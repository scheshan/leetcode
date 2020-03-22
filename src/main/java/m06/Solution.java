package m06;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        return travel(head, 1);
    }

    private int[] travel(ListNode node, int n) {
        if (node == null) {
            return new int[0];
        }

        if (node.next != null) {
            int[] arr = travel(node.next, n + 1);
            arr[arr.length - n] = node.val;
            return arr;
        } else {
            int[] arr = new int[n];
            arr[0] = node.val;
            return arr;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);

        new Solution().reversePrint(head);
    }
}
