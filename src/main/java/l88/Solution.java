package l88;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int left = m - 1;
        int right = n - 1;

        while (left >= 0 && right >= 0) {
            if (nums1[left] > nums2[right]) {
                nums1[i--] = nums1[left--];
            } else {
                nums1[i--] = nums2[right--];
            }
        }

        while (right >= 0) {
            nums1[i--] = nums2[right--];
        }
    }

    public static void main(String[] args) {
        new Solution().merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
