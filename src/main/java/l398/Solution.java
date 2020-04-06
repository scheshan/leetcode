package l398;

import java.util.Random;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/6
 */
public class Solution {

    private int[] nums;

    private Random rnd;

    public Solution(int[] nums) {
        this.nums = nums;
        rnd = new Random();
    }

    public int pick(int target) {
        int res = -1;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == target) {
                if (res == -1) {
                    res = j;
                } else {
                    if (random(i + 1) == i) {
                        res = j;
                    }
                }

                i++;
            }
        }

        return res;
    }

    private int random(int n) {
        return rnd.nextInt(n);
    }
}
