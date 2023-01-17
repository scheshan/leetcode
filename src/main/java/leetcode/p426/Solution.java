package leetcode.p426;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public class State {
        Node head;
        Node tail;
    }

    public Node treeToDoublyList(Node root) {
        State state = new State();
        dfs(root, state);

        if (state.head != null) {
            state.head.left = state.tail;
            state.tail.right = state.head;
        }

        return state.head;
    }

    private void dfs(Node node, State state) {
        if (node == null) {
            return;
        }

        dfs(node.left, state);

        node.left = state.tail;
        if (state.head == null) {
            state.head = node;
        } else {
            state.tail.right = node;
        }
        state.tail = node;

        dfs(node.right, state);
    }
}
