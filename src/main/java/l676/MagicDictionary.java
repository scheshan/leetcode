package l676;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class MagicDictionary {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {

    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        root = new Node();
        for (String word : dict) {
            insert(root, word);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        return find(root, word, 0, false);
    }

    private void insert(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';

            if (root.children[ind] == null) {
                root.children[ind] = new Node();
            }
            if (i == word.length() - 1) {
                root.children[ind].end = true;
            }
            root = root.children[ind];
        }
    }

    private boolean find(Node root, String word, int i, boolean replaced) {
        if (root == null) {
            return false;
        }
        if (i == word.length()) {
            return root.end && replaced;
        }

        boolean find = false;

        int ind = word.charAt(i) - 'a';
        Node child = root.children[ind];
        if (child != null) {
            find = find(child, word, i + 1, replaced);
        }

        if (find) {
            return true;
        } else {
            if (replaced) {
                return false;
            }

            replaced = true;
            for (int j = 0; j < root.children.length; j++) {
                if (j == ind || root.children[j] == null) {
                    continue;
                }

                find = find(root.children[j], word, i + 1, replaced);
                if (find) {
                    return true;
                }
            }
        }

        return false;
    }

    private class Node {
        private Node[] children;

        private boolean end;

        public Node() {
            children = new Node[26];
        }
    }

    public static void main(String[] args) {
        MagicDictionary md = new MagicDictionary();
        md.buildDict(new String[]{"hello", "leetcode"});
        //System.out.println(md.search("hello"));
        System.out.println(md.search("hhllo"));
    }
}
