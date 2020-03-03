package l590;

import shared.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        travel(root, result);

        return result;
    }

    private void travel(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            travel(child, list);
        }
        list.add(root.val);
    }
}
