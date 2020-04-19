package l212;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    private Node root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node(' ');
        for (String word : words) {
            insert(root, word);
        }

        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(res, board, root, new StringBuilder(), i, j);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(Set<String> res, char[][] board, Node node, StringBuilder sb, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == ' ') {
            return;
        }

        char ch = board[i][j];
        Node child = node.children[ch - 'a'];
        if (child == null) {
            return;
        }
        sb.append(ch);
        board[i][j] = ' ';

        if (child.end) {
            res.add(sb.toString());
        }

        dfs(res, board, child, sb, i - 1, j);
        dfs(res, board, child, sb, i + 1, j);
        dfs(res, board, child, sb, i, j - 1);
        dfs(res, board, child, sb, i, j + 1);

        sb.deleteCharAt(sb.length() - 1);
        board[i][j] = ch;
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
        char[][] boarad = new char[][]{
                new char[]{'o', 'a', 'a', 'n'},
                new char[]{'e', 't', 'a', 'e'},
                new char[]{'i', 'h', 'k', 'r'},
                new char[]{'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};

        new Solution().findWords(boarad, words);
    }
}
