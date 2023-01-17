package leetcode.p1305;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        dfs(root1, l1);
        dfs(root2, l2);

        return merge(l1, l2);
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }

    private List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>(l1.size() + l2.size());

        int l = 0;
        int r = 0;
        while (l < l1.size() && r < l2.size()) {
            if (l1.get(l) < l2.get(r)) {
                res.add(l1.get(l));
                l++;
            } else {
                res.add(l2.get(r));
                r++;
            }
        }
        while (l < l1.size()) {
            res.add(l1.get(l));
            l++;
        }
        while (r < l2.size()) {
            res.add(l2.get(r));
            r++;
        }
        return res;
    }
}
