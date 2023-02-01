package leetcode.p211;

/**
 * WordDictionary
 *
 * @author heshan
 * @date 2023/2/1
 */
public class WordDictionary {

    private class Node {
        boolean end;
        Node[] children;
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int ind) {
        if (node == null) {
            return false;
        }
        if (ind == word.length()) {
            return node.end;
        }
        if (node.children == null) {
            return false;
        }
        if (word.charAt(ind) != '.') {
            return search(node.children[word.charAt(ind) - 'a'], word, ind + 1);
        } else {
            for (Node child : node.children) {
                if (search(child, word, ind + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
