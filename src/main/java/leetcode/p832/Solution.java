package leetcode.p832;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int row = 0; row < image.length; row++) {
            int l = 0;
            int r = image[row].length - 1;
            while (l < r) {
                int tmp = image[row][l];
                image[row][l] = 1 - image[row][r];
                image[row][r] = 1 - tmp;
                l++;
                r--;
            }
            if (l == r) {
                image[row][l] = 1 - image[row][l];
            }
        }

        return image;
    }
}
