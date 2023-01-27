package leetcode.p667;

/**
 * MapSum
 *
 * @author heshan
 * @date 2023/1/27
 */
public class MapSum {

    private class Node {
        int val;
        Node[] children;
    }

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node node = root;
        for (int i = 0; i < key.length(); i++) {
            if (node.children == null) {
                node.children = new Node[26];
            }
            Node child = node.children[key.charAt(i) - 'a'];
            if (child == null) {
                child = new Node();
                node.children[key.charAt(i) - 'a'] = child;
            }
            node = child;
        }
        node.val = val;
    }

    public int sum(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length() && node != null; i++) {
            if (node.children != null) {
                node = node.children[prefix.charAt(i) - 'a'];
            } else {
                node = null;
            }
        }
        return sum(node);
    }

    private int sum(Node node) {
        if (node == null) {
            return 0;
        }

        int res = node.val;
        if (node.children != null) {
            for (int i = 0; i < node.children.length; i++) {
                res += sum(node.children[i]);
            }
        }
        return res;
    }
}
