package l229;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();

        int n1 = -1;
        int n2 = -1;
        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            if (num == n1) {
                c1++;
                continue;
            } else if (num == n2) {
                c2++;
                continue;
            }

            if (c1 == 0) {
                c1 = 1;
                n1 = num;
                continue;
            }
            if (c2 == 0) {
                c2 = 1;
                n2 = num;
                continue;
            }

            c1--;
            c2--;
        }

        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (num == n1) {
                c1++;
            } else if (num == n2) {
                c2++;
            }
        }

        if (c1 > nums.length / 3) {
            res.add(n1);
        }
        if (c2 > nums.length / 3) {
            res.add(n2);
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().majorityElement(new int[]{2, 2, 1, 3});
    }
}
