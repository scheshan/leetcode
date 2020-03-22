package l1189;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[5];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == 'a') {
                count[0]++;
            } else if (ch == 'b') {
                count[1]++;
            } else if (ch == 'l') {
                count[2]++;
            } else if (ch == 'o') {
                count[3]++;
            } else {
                count[4]++;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (i == 2 || i == 3) {
                min = Math.min(min, count[i] / 2);
            } else {
                min = Math.min(min, count[i]);
            }
        }

        return min;
    }
}
