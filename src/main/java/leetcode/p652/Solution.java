package leetcode.p652;

import common.TreeNode;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root, new HashMap<>(), new HashSet<>(), res);
        return res;
    }

    private String dfs(TreeNode node, Map<String, TreeNode> map, Set<String> visit, List<TreeNode> res) {
        if (node == null) {
            return "";
        }

        String left = dfs(node.left, map, visit, res);
        String right = dfs(node.right, map, visit, res);
        String hash = String.format("%s(%s,%s)", node.val, left, right);

        if (map.containsKey(hash)) {
            if (!visit.contains(hash)) {
                visit.add(hash);
                res.add(map.get(hash));
            }
        } else {
            map.put(hash, node);
        }
        return hash;
    }
}
