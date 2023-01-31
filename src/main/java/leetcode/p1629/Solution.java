package leetcode.p1629;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int pre = 0;
        int max = 0;
        char res = ' ';

        for (int i = 0; i < keysPressed.length(); i++) {
            char ch = keysPressed.charAt(i);
            int time = releaseTimes[i] - pre;
            if (time > max) {
                max = time;
                res = ch;
            } else if (time == max && ch > res) {
                res = ch;
            }
            pre = releaseTimes[i];
        }
        return res;
    }
}
