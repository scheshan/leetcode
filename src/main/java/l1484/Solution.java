package l1484;


import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/7/3
 */
public class Solution {

    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map = new HashMap<>();
        return dfs(root, map);
    }

    private NodeCopy dfs(Node node, Map<Node, NodeCopy> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        NodeCopy res = new NodeCopy(node.val);
        map.put(node, res);

        res.left = dfs(node.left, map);
        res.right = dfs(node.right, map);
        res.random = dfs(node.random, map);

        return res;
    }
}
