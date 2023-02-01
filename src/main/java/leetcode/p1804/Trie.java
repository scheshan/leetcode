package leetcode.p1804;

/**
 * Trie
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Trie {

    private class Node {
        int count;
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
            Node child = node.children[word.charAt(i) - 'a'];
            if (child == null) {
                child = new Node();
                node.children[word.charAt(i) - 'a'] = child;
            }
            node = child;
        }
        node.end = true;
        node.count++;
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length() && node != null; i++) {
            if (node.children != null) {
                node = node.children[word.charAt(i) - 'a'];
            } else {
                node = null;
            }
        }

        if (node != null && node.end) {
            return node.count;
        }
        return 0;
    }

    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length() && node != null; i++) {
            if (node.children != null) {
                node = node.children[prefix.charAt(i) - 'a'];
            } else {
                node = null;
            }
        }
        return dfs(node);
    }

    public void erase(String word) {
        //remove(root, word, 0);
        Node node = root;
        for (int i = 0; i < word.length() && node != null; i++) {
            if (node.children != null) {
                node = node.children[word.charAt(i) - 'a'];
            } else {
                node = null;
            }
        }

        if (node != null && node.end) {
            node.count--;
        }
    }

    private int dfs(Node node) {
        if (node == null) {
            return 0;
        }
        int res = node.count;
        if (node.children != null) {
            for (int i = 0; i < node.children.length; i++) {
                res += dfs(node.children[i]);
            }
        }
        return res;
    }

    private Node remove(Node node, String word, int ind) {
        if (node == null) {
            return null;
        }
        if (ind == word.length()) {
            node.count--;
            if (node.count == 0) {
                node.end = false;
                if (hasChildren(node)) {
                    return node;
                } else {
                    return null;
                }
            } else {
                return node;
            }
        } else {
            if (node.children != null) {
                Node child = node.children[word.charAt(ind) - 'a'];
                node.children[word.charAt(ind) - 'a'] = remove(child, word, ind + 1);
            }
            if (hasChildren(node)) {
                return node;
            }
            return null;
        }
    }

    private boolean hasChildren(Node node) {
        if (node.children != null) {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
