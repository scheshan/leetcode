package leetcode.p1506;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public Node findRoot(List<Node> tree) {
        int num = 0;
        for (Node node : tree) {
            num ^= node.val;
            for (Node child : node.children) {
                num ^= child.val;
            }
        }

        for (Node node : tree) {
            if (node.val == num) {
                return node;
            }
        }
        return null;
    }
}
