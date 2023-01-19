package offer2.p044;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode node, int level, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (list.size() <= level) {
            list.add(node.val);
        } else {
            if (node.val > list.get(level)) {
                list.set(level, node.val);
            }
        }

        dfs(node.left, level + 1, list);
        dfs(node.right, level + 1, list);
    }
}
