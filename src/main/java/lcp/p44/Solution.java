package lcp.p44;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public int numColor(TreeNode root) {
        boolean[] visit = new boolean[1001];
        return travel(root, visit);
    }

    private int travel(TreeNode node, boolean[] visit) {
        if (node == null) {
            return 0;
        }

        int res = travel(node.left, visit) + travel(node.right, visit);
        if (!visit[node.val]) {
            visit[node.val] = true;
            res++;
        }

        return res;
    }
}
