package leetcode.p215;

import java.util.Random;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    private Random rnd = new Random();

    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length - 1, nums.length - k);
    }

    private int find(int[] nums, int begin, int end, int k) {
        int pivot = rnd.nextInt(end - begin + 1) + begin;
        swap(nums, begin, pivot);

        int ind = quickSelect(nums, begin, end);
        if (ind == k) {
            return nums[ind];
        } else if (ind < k) {
            return find(nums, ind + 1, end, k);
        } else {
            return find(nums, begin, ind - 1, k);
        }
    }

    private int quickSelect(int[] nums, int begin, int end) {
        if (begin == end) {
            return begin;
        }

        int pivot = nums[begin];
        int l = begin;
        int r = end;
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
        swap(nums, begin, l);
        return l;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
