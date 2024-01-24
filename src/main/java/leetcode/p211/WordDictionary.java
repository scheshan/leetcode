package leetcode.p211;

/**
 * WordDictionary
 *
 * @author heshan
 * @date 2024/1/24
 */
public class WordDictionary {

    private class Node {
        boolean isEnd;
        Node[] children;
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (node.children == null) {
                node.children = new Node[26];
            }
            if (node.children[ind] == null) {
                node.children[ind] = new Node();
            }
            node = node.children[ind];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return find(word, 0, root);
    }

    private boolean find(String word, int ind, Node node) {
        if (ind == word.length()) {
            return node.isEnd;
        }

        if (node.children == null) {
            return false;
        }

        if (word.charAt(ind) == '.') {
            for (Node child : node.children) {
                if (child != null && find(word, ind + 1, child)) {
                    return true;
                }
            }
        } else if (node.children[word.charAt(ind) - 'a'] != null) {
            return find(word, ind + 1, node.children[word.charAt(ind) - 'a']);
        }
        return false;
    }
}
