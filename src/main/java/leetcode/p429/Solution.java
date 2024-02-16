package leetcode.p429;

import common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                list.add(node.val);

                for (Node child : node.children) {
                    queue.add(child);
                }
            }

            res.add(list);
        }

        return res;
    }
}
