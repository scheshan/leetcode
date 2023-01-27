package offer2.p007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) {
                break;
            }

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int n = nums[l] + nums[r] + nums[i];
                if (n == 0) {
                    List<Integer> item = new ArrayList<>(3);
                    item.add(nums[i]);
                    item.add(nums[l]);
                    item.add(nums[r]);
                    res.add(item);
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    r--;
                    while (r > l && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (n < 0) {
                    l++;
                } else{
                    r--;
                }
            }

            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
        }

        return res;
    }
}
