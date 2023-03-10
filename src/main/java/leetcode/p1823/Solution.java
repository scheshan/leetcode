package leetcode.p1823;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/8
 */
public class Solution {

    private class Node {

        int value;

        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public int findTheWinner(int n, int k) {
        Node dummy = new Node(-1);
        Node tail = dummy;
        for (int i = 1; i <= n; i++) {
            tail.next = new Node(i);
            tail = tail.next;
        }

        Node head = dummy.next;
        tail.next = head;

        Node pre = tail;
        Node cur = head;
        while (n > 1) {
            int cnt = (k - 1) % n;
            for (int i = 0; i < cnt; i++) {
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = cur.next;
            cur = cur.next;
            n--;
        }

        return cur.value;
    }
}
