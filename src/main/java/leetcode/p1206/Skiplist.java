package leetcode.p1206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * SkipList
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Skiplist {

    private class Node {
        int val;
        Node next;
        Node down;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node top;

    private Random rnd;

    public Skiplist() {
        top = new Node(Integer.MIN_VALUE);
        rnd = new Random();
    }

    public boolean search(int target) {
        Node node = top;
        while (node != null) {
            while (node.next != null && node.next.val < target) {
                node = node.next;
            }
            if (node.next != null && node.next.val == target) {
                return true;
            }
            node = node.down;
        }
        return false;
    }

    public void add(int num) {
        List<Node> path = new ArrayList<>();
        Node node = top;
        while (node != null) {
            while (node.next != null && node.next.val < num) {
                node = node.next;
            }
            path.add(node);
            node = node.down;
        }

        boolean needInsert = true;
        Node downNode = null;
        for (int i = path.size() - 1; i >= 0 && needInsert; i--) {
            Node n1 = new Node(num);
            n1.next = path.get(i).next;
            path.get(i).next = n1;
            n1.down = downNode;
            downNode = n1;
            needInsert = rnd.nextBoolean();
        }

        if (needInsert) {
            Node newTop = new Node(Integer.MIN_VALUE);
            newTop.down = top;
            this.top = newTop;
        }
    }

    public boolean erase(int num) {
        boolean res = false;
        Node node = top;
        while (node != null) {
            while (node.next != null && node.next.val < num) {
                node = node.next;
            }
            if (node.next != null && node.next.val == num) {
                res = true;
                node.next = node.next.next;
            }
            node = node.down;
        }
        return res;
    }

    public static void main(String[] args) {
        Skiplist sl = new Skiplist();
        sl.add(0);
        sl.add(5);
        sl.add(2);
        sl.add(1);
        System.out.println(sl.search(0));
        System.out.println(sl.erase(5));
    }
}
