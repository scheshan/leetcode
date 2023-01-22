package offer.p32_03;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
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

            if (level == 1) {
                int l = 0;
                int r = list.size() - 1;
                while (l < r) {
                    int tmp = list.get(l);
                    list.set(l, list.get(r));
                    list.set(r, tmp);
                    l++;
                    r--;
                }
            }
            res.add(list);
            level = 1 - level;
        }
        return res;
    }
}
