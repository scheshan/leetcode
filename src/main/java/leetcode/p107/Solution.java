package leetcode.p107;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/5
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(list);
        }

        reverse(res);

        return res;
    }

    private void reverse(List list) {
        int l = 0;
        int r = list.size() - 1;

        while (l < r) {
            Object o = list.get(l);
            list.set(l, list.get(r));
            list.set(r, o);

            l++;
            r--;
        }
    }
}
