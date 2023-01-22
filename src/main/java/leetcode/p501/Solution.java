package leetcode.p501;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    private List<Integer> res = new ArrayList<>();

    private TreeNode pre;

    private int cur;

    private int max;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);

        if (pre != null && pre.val == node.val) {
            cur++;
        } else {
            cur = 1;
        }
        pre = node;
        if (cur > max) {
            max = cur;
            res.clear();
            res.add(node.val);
        } else if (cur == max) {
            res.add(node.val);
        }

        dfs(node.right);
    }
}
