package l1490;

import shared.Node;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/7/1
 */
public class Solution {

    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }

        Node clone = new Node(root.val);
        for (Node child : root.children) {
            clone.children.add(cloneTree(child));
        }

        return clone;
    }
}
