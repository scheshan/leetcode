package l1032;

import java.util.LinkedList;
import java.util.Queue;

/**
 * StreamChecker
 *
 * @author heshan
 * @date 2020/4/19
 */
public class StreamChecker {

    private Node root;

    private Queue<Node> queue;

    public StreamChecker(String[] words) {
        root = new Node(' ');
        for (String word : words) {
            insert(root, word);
        }
        queue = new LinkedList<>();
    }

    public boolean query(char letter) {
        Queue<Node> q = new LinkedList<>();

        boolean match = false;

        if (root.children[letter - 'a'] != null) {
            Node n = root.children[letter - 'a'];
            if (n.end) {
                match = true;
            }
            q.add(n);
        }
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.children[letter - 'a'] == null) {
                continue;
            }
            Node n = node.children[letter - 'a'];
            if (n.end) {
                match = true;
            }
            q.add(n);
        }
        queue = q;

        return match;
    }

    private void insert(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (root.children[ch - 'a'] == null) {
                root.children[ch - 'a'] = new Node(ch);
            }
            root = root.children[ch - 'a'];
            if (i == word.length() - 1) {
                root.end = true;
            }
        }
    }

    private class Node {

        private char ch;

        private boolean end;

        private Node[] children;

        public Node(char ch) {
            this.ch = ch;
            children = new Node[26];
        }
    }

    public static void main(String[] args) {
        StreamChecker sc = new StreamChecker(new String[]{"abaa", "abaab", "aabbb", "bab", "ab"});
        sc.query('a');
        sc.query('a');
        sc.query('b');
        sc.query('b');
        sc.query('b');
    }
}
