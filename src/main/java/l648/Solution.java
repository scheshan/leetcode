package l648;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public String replaceWords(List<String> dict, String sentence) {
        Node root = new Node(' ');
        for (String word : dict) {
            insert(root, word);
        }

        String[] words = sentence.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.length() > 0) {
                sb.append(" ");
            }

            sb.append(replace(root, word));
        }

        return sb.toString();
    }

    private void insert(Node node, String word) {
        for (int i = 0; i < word.length(); i++) {
            node = node.children.compute(word.charAt(i), (k, v) -> {
                if (v == null) {
                    v = new Node(k);
                }
                return v;
            });
            if (i == word.length() - 1) {
                node.end = true;
            }
        }
    }

    private String replace(Node node, String word) {
        for (int i = 0; i < word.length(); i++) {
            node = node.children.get(word.charAt(i));
            if (node == null) {
                return word;
            }
            if (node.end) {
                return word.substring(0, i + 1);
            }
        }

        return word;
    }

    private class Node {

        char ch;

        boolean end;

        Map<Character, Node> children = new HashMap<>();

        public Node(char ch) {
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        new Solution().replaceWords(dict, "the cattle was rattled by the battery");
    }
}
