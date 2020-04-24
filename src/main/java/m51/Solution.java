package m51;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    private int[] tmp;

    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        return count(nums, 0, nums.length - 1);
    }

    private int count(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (left + right) / 2;
        int res = 0;

        res += count(nums, left, mid);
        res += count(nums, mid + 1, right);

        res += merge(nums, left, mid, right);
        return res;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int ind = left;
        int l = left;
        int r = mid + 1;

        int res = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                tmp[ind++] = nums[l++];
            } else {
                tmp[ind++] = nums[r++];
                res += mid - l + 1;
            }
        }
        while (l <= mid) {
            tmp[ind++] = nums[l++];
        }
        while (r <= right) {
            tmp[ind++] = nums[r++];
        }

        for (int i = left; i <= right; i++) {
            nums[i] = tmp[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(res);
    }
}
