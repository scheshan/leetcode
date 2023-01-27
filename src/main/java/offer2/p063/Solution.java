package offer2.p063;

import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    private class Node {
        String str;
        boolean end;
        Node[] children;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for (String word : dictionary) {
            insert(root, word);
        }

        StringBuilder sb = new StringBuilder();
        int l = 0;
        int r = 0;
        while (r < sentence.length()) {
            while (r < sentence.length() && sentence.charAt(r) != ' ') {
                r++;
            }
            replace(root, sentence, l, r, sb);

            if (r < sentence.length()) {
                r++;
                sb.append(' ');
            }
            l = r;
        }
        return sb.toString();
    }

    private void insert(Node root, String word) {
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
        node.str = word;
    }

    private void replace(Node root, String str, int l, int r, StringBuilder sb) {
        Node node = root;
        for (int i = l; i < r && node != null; i++) {
            if (node.children != null) {
                node = node.children[str.charAt(i) - 'a'];
                if (node != null && node.end) {
                    sb.append(node.str);
                    return;
                }
            } else {
                node = null;
            }
        }
        sb.append(str.substring(l, r));
    }
}
