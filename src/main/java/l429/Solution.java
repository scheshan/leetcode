package l429;

import shared.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        List<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Node> list = queue;
            queue = new LinkedList<>();

            List<Integer> nums = new LinkedList<>();

            for (Node node : list) {
                nums.add(node.val);

                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            result.add(nums);
        }

        return result;
    }
}
