package m34;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/15
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        travel(root, result, path, 0, sum);

        return result;
    }

    private void travel(TreeNode node, List<List<Integer>> result, LinkedList<Integer> path, int cur, int sum) {
        if (node == null) {
            return;
        }

        path.addLast(node.val);
        cur += node.val;

        if (node.left == null && node.right == null && cur == sum) {
            result.add(new ArrayList<>(path));
        } else {
            travel(node.left, result, path, cur, sum);
            travel(node.right, result, path, cur, sum);
        }

        path.removeLast();
    }
}
