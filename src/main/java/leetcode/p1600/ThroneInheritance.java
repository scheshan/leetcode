package leetcode.p1600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ThroneInheritance
 *
 * @author heshan
 * @date 2023/2/14
 */
public class ThroneInheritance {

    private class Node {
        String name;
        List<Node> children;
        boolean dead;

        public Node(String name) {
            this.name = name;
        }
    }

    private Node root;

    private Map<String, Node> map;

    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        root = newNode(kingName);
    }

    public void birth(String parentName, String childName) {
        Node node = map.get(parentName);
        if (node.children == null) {
            node.children = new ArrayList<>();
        }

        node.children.add(newNode(childName));
    }

    public void death(String name) {
        map.get(name).dead = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node node, List<String> res) {
        if (node == null) {
            return;
        }

        if (!node.dead) {
            res.add(node.name);
        }
        if (node.children != null) {
            for (Node child : node.children) {
                dfs(child, res);
            }
        }
    }

    private Node newNode(String name) {
        Node node = new Node(name);
        map.put(name, node);
        return node;
    }
}
