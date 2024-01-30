package leetcode.p215;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            heap(nums, i);
        }

        int size = nums.length - 1, res = 0;
        for (int i = 0; i < k; i++) {
            res = removeHeap(nums, size--);
        }

        return res;
    }

    private int removeHeap(int[] nums, int size) {
        int res = nums[0];
        swap(nums, 0, size);
        int ind = 0, left = ind * 2 + 1, right = ind * 2 + 2;
        while (left < size || right < size) {
            int maxInd = left;
            if (right < size && nums[right] > nums[left]) {
                maxInd = right;
            }

            if (nums[maxInd] <= nums[ind]) {
                break;
            }

            swap(nums, maxInd, ind);
            ind = maxInd;
            left = ind * 2 + 1;
            right = ind * 2 + 2;
        }

        return res;
    }

    private void heap(int[] nums, int ind) {
        while (ind > 0) {
            int parent = (ind - 1) >> 1;
            if (nums[ind] > nums[parent]) {
                swap(nums, ind, parent);
                ind = parent;
            } else {
                return;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int d = nums[i];
        nums[i] = nums[j];
        nums[j] = d;
    }
}
