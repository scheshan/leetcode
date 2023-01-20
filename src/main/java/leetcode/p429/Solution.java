package leetcode.p429;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
public class Solution {

    class Node {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 1, res);
        return res;
    }

    private void dfs(Node node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }
        res.get(level - 1).add(node.val);
        for (Node child : node.children) {
            dfs(child, level + 1, res);
        }
    }
}
