package l725;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (k == 0) {
            return res;
        }

        int total = 0;
        ListNode cur = root;
        while (cur != null) {
            total++;
            cur = cur.next;
        }

        int n = total / k;
        int mod = total % k;

        cur = root;
        for (int i = 0; i < res.length; i++) {
            res[i] = cur;
            cur = split(cur, i < mod ? n + 1 : n);
        }

        return res;
    }

    private ListNode split(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            if (cur == null) {
                break;
            }
            cur = cur.next;
        }

        ListNode next = cur.next;
        cur.next = null;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        new Solution().splitListToParts(head, 5);
    }
}
