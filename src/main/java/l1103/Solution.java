package l1103;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/5
 */
public class Solution {

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];

        int num = 1;
        while (candies > 0) {
            int count = Math.min(num, candies);
            result[(num - 1) % num_people] += count;
            candies -= count;

            num++;
        }

        return result;
    }
}
