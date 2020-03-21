package l677;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class MapSum {

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        insert(root, key, 0, val);
    }

    private void insert(Node node, String word, int i, int val) {
        int ind = word.charAt(i) - 'a';
        if (node.children[ind] == null) {
            node.children[ind] = new Node();
        }
        if (i == word.length() - 1) {
            node.children[ind].value = val;
        } else {
            insert(node.children[ind], word, i + 1, val);
        }
    }

    public int sum(String prefix) {
        Node node = root;

        for (int i = 0; i < prefix.length() && node != null; i++) {
            int ind = prefix.charAt(i) - 'a';
            node = node.children[ind];
        }

        if (node == null) {
            return 0;
        }

        return travel(node);
    }

    private int travel(Node node) {
        int sum = node.value;
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                sum += travel(node.children[i]);
            }
        }

        return sum;
    }

    class Node {

        private Node[] children;

        private int value;

        public Node() {
            children = new Node[26];
        }
    }
}
