package l1629;

/**
 * Solution
 *
 * @author heshan
 * @date 2021/1/8
 */
public class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ch = ' ';
        int max = 0;

        for (int i = 0; i < keysPressed.length(); i++) {
            int time = releaseTimes[i];
            if (i > 0) {
                time -= releaseTimes[i - 1];
            }

            if (time > max) {
                ch = keysPressed.charAt(i);
                max = time;
            } else if(time == max) {
                ch = (char) Math.max(ch, keysPressed.charAt(i));
            }
        }

        return ch;
    }
}
