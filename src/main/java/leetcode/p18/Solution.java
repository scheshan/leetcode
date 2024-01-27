package leetcode.p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && i < nums.length - 3 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && j < nums.length - 2 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    while (l < r && l > j + 1 && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && r < nums.length - 1 && nums[r] == nums[r + 1]) {
                        r--;
                    }

                    if (l >= r) {
                        break;
                    }

                    long total = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];
                    if (total < target) {
                        l++;
                    } else if (total > target) {
                        r--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    }
                }
            }
        }

        return res;
    }
}
