package l18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/31
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (target > 0 && nums[i] > target) {
                break;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if (target > 0 && nums[i] + nums[j] > target) {
                    break;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else {
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
    }
}
