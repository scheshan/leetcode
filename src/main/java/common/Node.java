package common;

import java.util.List;

/**
 * Node
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
