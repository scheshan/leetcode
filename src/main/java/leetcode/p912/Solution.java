package leetcode.p912;

import java.util.Random;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/4
 */
public class Solution {

    private Random rnd = new Random();

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int pi = begin + rnd.nextInt(end - begin);
        swap(nums, begin, pi);
        int pivot = nums[begin];

        int l = begin;
        int r = end;
        while (l < r) {
            while (l < r && nums[r] > pivot) {
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

        quickSort(nums, begin, l - 1);
        quickSort(nums, l + 1, end);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
