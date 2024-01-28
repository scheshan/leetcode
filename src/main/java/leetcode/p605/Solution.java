package leetcode.p605;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i > 0 && flowerbed[i - 1] == 1) {
                    continue;
                }
                if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                    continue;
                }
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}
