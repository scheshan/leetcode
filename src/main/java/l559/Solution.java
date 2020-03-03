package l559;

import shared.Node;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }

        return max + 1;
    }
}
