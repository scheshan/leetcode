package m16_01;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] += numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] = numbers[0];

        return numbers;
    }
}
