package offer2.p028;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    class State {
        Node head;
        Node tail;
    }

    public Node flatten(Node head) {
        State state = new State();
        dfs(head, state);

        return state.head;
    }

    private void dfs(Node node, State state) {
        if (node == null) {
            return;
        }

        node.prev = state.tail;
        if (state.head == null) {
            state.head = node;
        } else {
            state.tail.next = node;
        }
        state.tail = node;

        Node child = node.child;
        Node next = node.next;
        node.child = null;
        node.next = null;

        dfs(child, state);
        dfs(next, state);
    }
}
