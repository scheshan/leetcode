package leetcode.p208;

/**
 * Trie
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Trie {

    private class Node {
        boolean end;
        Node[] children;
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children == null) {
                node.children = new Node[26];
            }
            int ind = word.charAt(i) - 'a';
            if (node.children[ind] == null) {
                node.children[ind] = new Node();
            }
            node = node.children[ind];
        }

        node.end = true;
    }

    public boolean search(String word) {
        Node node = find(word);
        return node != null && node.end;
    }

    public boolean startsWith(String prefix) {
        Node node = find(prefix);
        return node != null;
    }

    private Node find(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node == null || node.children == null) {
                return null;
            }
            node = node.children[word.charAt(i) - 'a'];
        }

        return node;
    }
}
