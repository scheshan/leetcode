package leetcode.p590;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        travel(res, root);

        return res;
    }

    private void travel(List<Integer> res, Node node) {
        if (node == null) {
            return;
        }

        for (Node child : node.children) {
            travel(res, child);
        }

        res.add(node.val);
    }
}
