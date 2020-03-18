package l430;

/**
 * Node
 *
 * @author heshan
 * @date 2020/3/18
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    public Node() {
    }
}
