package leetcode.p307;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class NumArray {

    private int size;

    private int[] tree;

    public NumArray(int[] nums) {
        this.tree = new int[nums.length * 4];
        this.buildTree(0, nums, 0, nums.length - 1);
        this.size = nums.length;
    }

    public void update(int index, int val) {
        update(0, 0, size - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return sumRange(0, 0, size - 1, left, right);
    }

    private void update(int ind, int l, int r, int target, int val) {
        if (l == r) {
            tree[ind] = val;
            return;
        }

        int leftInd = (ind << 1) + 1;
        int rightInd = leftInd + 1;
        int mid = l + ((r - l) >> 1);
        if (target <= mid) {
            update(leftInd, l, mid, target, val);
        } else {
            update(rightInd, mid + 1, r, target, val);
        }
        tree[ind] = tree[leftInd] + tree[rightInd];
    }

    private int sumRange(int ind, int l, int r, int left, int right) {
        if (l == left && r == right) {
            return tree[ind];
        }

        int leftInd = (ind << 1) + 1;
        int rightInd = leftInd + 1;
        int mid = l + ((r - l) >> 1);

        if (right <= mid) {
            return sumRange(leftInd, l, mid, left, right);
        } else if (left > mid) {
            return sumRange(rightInd, mid + 1, r, left, right);
        } else {
            return sumRange(leftInd, l, mid, left, mid) + sumRange(rightInd, mid + 1, r, mid + 1, right);
        }
    }

    private void buildTree(int ind, int[] nums, int l, int r) {
        if (l == r) {
            this.tree[ind] = nums[l];
            return;
        }

        int leftInd = (ind << 1) + 1;
        int rightInd = leftInd + 1;
        int mid = l + ((r - l) >> 1);
        buildTree(leftInd, nums, l, mid);
        buildTree(rightInd, nums, mid + 1, r);
        tree[ind] = tree[leftInd] + tree[rightInd];
    }
}
