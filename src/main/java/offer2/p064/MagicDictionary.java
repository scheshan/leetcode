package offer2.p064;

/**
 * MagicDictionary
 *
 * @author heshan
 * @date 2023/1/27
 */
public class MagicDictionary {

    private class Node {
        boolean end;
        Node[] children;
    }

    private Node root;

    public MagicDictionary() {
        root = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            insert(word);
        }
    }

    private void insert(String word) {
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

    public boolean search(String searchWord) {
        return find(root, searchWord, 0, true);
    }

    private boolean find(Node node, String word, int ind, boolean allowReplace) {
        if (node == null) {
            return false;
        }
        if (ind == word.length()) {
            return node.end && !allowReplace;
        }
        if (node.children == null) {
            return false;
        }

        Node child = node.children[word.charAt(ind) - 'a'];
        if (find(child, word, ind + 1, allowReplace)) {
            return true;
        }

        if (allowReplace) {
            for (int j = 0; j < 26; j++) {
                if (j != word.charAt(ind) - 'a' && find(node.children[j], word, ind + 1, false)) {
                    return true;
                }
            }
        }
        return false;
    }
}
