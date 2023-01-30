package leetcode.p605;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && ((i == 0 || flowerbed[i - 1] == 0)) && ((i == flowerbed.length - 1 || flowerbed[i + 1] == 0))) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}
