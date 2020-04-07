package l1170;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordCount = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordCount[i] = f(words[i]);
        }
        Arrays.sort(wordCount);

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = f(queries[i]);

            res[i] = find(wordCount, n + 1);
        }

        return res;
    }

    private int f(String s) {
        int res = 1;
        char c = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < c) {
                c = s.charAt(i);
                res = 1;
            } else if (s.charAt(i) == c) {
                res++;
            }
        }

        return res;
    }

    private int find(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                while (mid > 0 && nums[mid - 1] == target) {
                    mid--;
                }
                return nums.length - mid;
            }
        }

        return nums.length - left;
    }
}
