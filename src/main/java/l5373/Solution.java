package l5373;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = build(k);

        return count(list, k);
    }

    private int count(List<Integer> list, int target) {
        int ind = index(list, target);
        if (list.get(ind) == target) {
            return 1;
        }

        target -= list.get(ind);
        return count(list, target) + 1;
    }

    private int index(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) == target) {
                return mid;
            } else if (nums.get(mid) < target) {
                if (mid < nums.size() - 1 && nums.get(mid + 1) > target) {
                    return mid;
                }
                left = mid + 1;
            } else {
                if (mid > 0 && nums.get(mid - 1) < target) {
                    return mid - 1;
                }
                right = mid;
            }
        }

        return left;
    }

    private List<Integer> build(int k) {
        int x = 1;
        int y = 2;
        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        while (true) {
            int n = x + y;
            list.add(n);
            x = y;
            y = n;

            if (n > k) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int res = new Solution().findMinFibonacciNumbers(9083494);
        System.out.println(res);
    }
}
