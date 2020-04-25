package l894;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public List<TreeNode> allPossibleFBT(int N) {
        if ((N & 1) == 0) {
            return new ArrayList<>();
        }
        return build(N);
    }

    private List<TreeNode> build(int N) {
        List<TreeNode> res = new LinkedList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        N -= 1;
        for (int i = 1; i <= N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> res = new Solution().allPossibleFBT(3);
    }
}
