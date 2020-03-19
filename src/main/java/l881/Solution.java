package l881;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int result = 0;

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (left == right) {
                result++;
                break;
            } else {
                if (people[right] == limit || people[left] + people[right] > limit) {
                    result++;
                    right--;
                } else {
                    result++;
                    right--;
                    left++;
                }
            }
        }

        return result;
    }
}
