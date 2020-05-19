package l792;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/19
 */
public class Solution {

    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;

        Node root = new Node(' ');

        for (String w : words) {
            if (match(root, S, w)) {
                res++;
            }
        }
        return res;
    }

    private boolean match(Node root, String left, String right) {
        int i = 0;
        int j = 0;
        for (; j < right.length(); j++) {
            if (root.index == -1) {
                break;
            }

            int ind = right.charAt(j) - 'a';
            if (root.children[ind] != null) {
                root = root.children[ind];
                i = root.index + 1;
            } else {
                while (i < left.length() && left.charAt(i) != right.charAt(j)) {
                    i++;
                }
                Node n = new Node(right.charAt(j));
                n.index = i >= left.length() ? -1 : i;
                root.children[ind] = n;
                root = n;
                i++;
            }
        }

        return root.index != -1 && j == right.length();
    }

    private class Node {

        char ch;

        int index;

        Node[] children;

        public Node(char ch) {
            this.ch = ch;
            children = new Node[26];
        }
    }
}
