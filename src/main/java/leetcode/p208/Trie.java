package leetcode.p208;

/**
 * Trie
 *
 * @author heshan
 * @date 2023/1/27
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

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children == null) {
                node.children = new Node[26];
            }
            Node child = node.children[word.charAt(i) - 'a'];
            if (child == null) {
                child = new Node();
                node.children[word.charAt(i) - 'a'] = child;
            }
            node = child;
        }
        node.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length() && node != null; i++) {
            if (node.children != null) {
                node = node.children[word.charAt(i) - 'a'];
            } else {
                node = null;
            }
        }
        return node != null && node.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length() && node != null; i++) {
            if (node.children != null) {
                node = node.children[prefix.charAt(i) - 'a'];
            } else {
                node = null;
            }
        }
        return node != null;
    }
}
