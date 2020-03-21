package l208;

/**
 * Trie
 *
 * @author heshan
 * @date 2020/3/21
 */
class Trie {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(root, word, 0);
    }

    private void insert(Node node, String word, int i) {
        int ind = word.charAt(i) - 'a';
        if (node.children[ind] == null) {
            node.children[ind] = new Node();
        }
        if (i == word.length() - 1) {
            node.children[ind].end = true;
        } else {
            insert(node.children[ind], word, i + 1);
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = find(root, word, 0);
        return node != null && node.end;
    }

    private Node find(Node node, String word, int i) {
        if (node == null) {
            return null;
        }

        int ind = word.charAt(i) - 'a';
        if (node.children[ind] == null) {
            return null;
        }

        Node child = node.children[ind];
        if (i == word.length() - 1) {
            return child;
        }

        return find(child, word, i + 1);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node node = find(root, prefix, 0);
        return node != null;
    }

    class Node {

        private Node[] children;

        private boolean end;

        public Node() {
            children = new Node[26];
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }
}
