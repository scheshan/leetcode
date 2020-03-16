package l1261;

import shared.TreeNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
class FindElements {

    private TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;

        dfs(root, 0);
    }

    private void dfs(TreeNode node, int value) {
        if (node == null) {
            return;
        }

        node.val = value;
        dfs(node.left, (value << 1) + 1);
        dfs(node.right, (value << 1) + 2);
    }

    public boolean find(int target) {
        return find(root, target);
    }

    private boolean find(TreeNode node, int target) {
        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        }

        return find(node.left, target) || find(node.right, target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);

        FindElements fe = new FindElements(root);
        fe.find(1);
        fe.find(2);
    }
}
