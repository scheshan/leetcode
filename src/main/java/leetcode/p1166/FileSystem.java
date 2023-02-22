package leetcode.p1166;

import java.util.HashMap;
import java.util.Map;

/**
 * FileSystem
 *
 * @author heshan
 * @date 2023/2/22
 */
public class FileSystem {

    private class Node {

        boolean end;

        int value;

        Map<String, Node> children = new HashMap<>();
    }

    private Node root;

    public FileSystem() {
        root = new Node();
    }

    public boolean createPath(String path, int value) {
        Node node = root;
        int ind = 1;
        while (ind < path.length()) {
            int pre = ind;
            while (ind < path.length() && path.charAt(ind) != '/') {
                ind++;
            }
            String seg = path.substring(pre, ind);
            Node child = node.children.get(seg);

            if (ind < path.length() && child == null) {
                return false;
            } else if (ind == path.length() && child != null) {
                return false;
            }

            if (child == null) {
                child = new Node();
                node.children.put(seg, child);
            }
            node = child;
            ind++;
        }

        node.end = true;
        node.value = value;
        return true;
    }

    public int get(String path) {
        Node node = root;
        int ind = 1;
        while (ind < path.length()) {
            int pre = ind;
            while (ind < path.length() && path.charAt(ind) != '/') {
                ind++;
            }
            String seg = path.substring(pre, ind);
            Node child = node.children.get(seg);
            if (child == null) {
                return -1;
            }
            node = child;
            ind++;
        }
        return node.end ? node.value : -1;
    }
}
