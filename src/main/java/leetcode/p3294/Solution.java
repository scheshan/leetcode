package leetcode.p3294;

class Node {
    public int val;
    public Node prev;
    public Node next;
}

public class Solution {

    public int[] toArray(Node node) {
        if (node == null) {
            return new int[0];
        }

        Node head = node;
        Node n = node.prev;
        while (n != null) {
            n = n.prev;
            head = head.prev;
        }

        int cnt = 0;
        Node h = head;
        while (h != null) {
            cnt++;
            h = h.next;
        }

        int[] res = new int[cnt];
        int ind = 0;
        while (head != null) {
            res[ind++] = head.val;
            head = head.next;
        }

        return res;
    }
}
