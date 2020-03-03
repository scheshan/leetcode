package l1305;

import shared.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        travel(root1, l1);
        travel(root2, l2);

        List<Integer> result = new LinkedList<>();
        while (!l1.isEmpty() && !l2.isEmpty()) {
            if (l1.peekFirst() < l2.peekFirst()) {
                result.add(l1.removeFirst());
            } else {
                result.add(l2.removeFirst());
            }
        }

        if (!l1.isEmpty()) {
            result.addAll(l1);
        }
        if (!l2.isEmpty()) {
            result.addAll(l2);
        }

        return result;
    }

    private void travel(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        travel(root.left, list);
        list.add(root.val);
        travel(root.right, list);
    }
}
