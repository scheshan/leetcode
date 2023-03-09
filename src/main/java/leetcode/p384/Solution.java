package leetcode.p384;

import java.util.Random;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/10
 */
public class Solution {

    private int[] nums;

    private int[] arr;

    private Random rnd;

    public Solution(int[] nums) {
        rnd = new Random();
        this.nums = nums;
        this.arr = new int[nums.length];
        reset();
    }

    public int[] reset() {
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }

    public int[] shuffle() {
        for (int i = 0; i < arr.length; i++) {
            int j = i + rnd.nextInt(arr.length - i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }
}
