package leetcode.p1032;

import java.util.ArrayList;
import java.util.List;

/**
 * StreamChecker
 *
 * @author heshan
 * @date 2023/3/24
 */
public class StreamChecker {

    private class Node {

        Node[] children;

        boolean end;
    }

    private Node root;

    private List<Character> list;

    public StreamChecker(String[] words) {
        root = new Node();
        list = new ArrayList<>(10000);
        for (String word : words) {
            insert(word);
        }
    }

    private void insert(String word) {
        Node node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
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

    public boolean query(char letter) {
        list.add(letter);
        Node node = root;

        for (int i = list.size() - 1; i >= 0; i--) {
            if (node.children == null || node.children[list.get(i) - 'a'] == null) {
                break;
            }
            node = node.children[list.get(i) - 'a'];
            if (node.end) {
                break;
            }
        }

        return node.end;
    }
}
