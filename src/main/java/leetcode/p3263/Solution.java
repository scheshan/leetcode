package leetcode.p3263;

class Node {
    public int val;
    public Node prev;
    public Node next;
}

public class Solution {

    public int[] toArray(Node head) {
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
