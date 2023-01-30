package leetcode.p536;

import common.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    int ind;

    public TreeNode str2tree(String s) {
        if (ind >= s.length()) {
            return null;
        }

        TreeNode node = new TreeNode(0);

        int multi = 1;
        if (s.charAt(ind) == '-') {
            ind++;
            multi = -1;
        }

        while (ind < s.length() && s.charAt(ind) >= '0' && s.charAt(ind) <= '9') {
            node.val = node.val * 10 + s.charAt(ind) - '0';
            ind++;
        }
        node.val *= multi;

        if (ind < s.length() && s.charAt(ind) == '(') {
            ind++;
            node.left = str2tree(s);
        }
        if (ind < s.length() && s.charAt(ind) == '(') {
            ind++;
            node.right = str2tree(s);
        }
        ind++;
        return node;
    }
}
