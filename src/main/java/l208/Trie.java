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

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (node.children == null || node.children[ind] == null) {
                return false;
            }
            node = node.children[ind];
        }
        return node.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int ind = prefix.charAt(i) - 'a';
            if (node.children == null || node.children[ind] == null) {
                return false;
            }
        }
        return true;
    }

    private class Node {

        Node[] children;

        private boolean end;

        public Node() {

        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        final boolean res = trie.search("apple");
        System.out.println(res);
    }
}
