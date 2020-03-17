package l653;

import shared.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/17
 */
public class Solution {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();

        return travel(root, set, k);
    }

    private boolean travel(TreeNode root, Set<Integer> set, int k) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);

        return travel(root.left, set, k) || travel(root.right, set, k);
    }
}
