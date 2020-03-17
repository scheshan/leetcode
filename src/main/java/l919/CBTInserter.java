package l919;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/17
 */
class CBTInserter {

    private ArrayList<TreeNode> array;

    public CBTInserter(TreeNode root) {
        array = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            array.add(node);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public int insert(int v) {
        int index = array.size();

        TreeNode node = new TreeNode(v);
        array.add(node);

        TreeNode parent = array.get(index - 1 / 2);
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return array.get(0);
    }

    public static void main(String[] args) {
        System.out.println(1 - 1 / 2);
    }
}
