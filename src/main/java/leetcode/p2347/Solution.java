package leetcode.p2347;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/20
 */
public class Solution {

    public String bestHand(int[] ranks, char[] suits) {
        int[] numbers = new int[13];
        int[] colors = new int[4];

        for (int r : ranks) {
            numbers[r - 1]++;
        }
        for (char s : suits) {
            colors[s - 'a']++;
        }

        for (int i = 0; i < 4; i++) {
            if (colors[i] == 5) {
                return "Flush";
            }
        }

        int maxCount = 0;
        for (int cnt : numbers) {
            maxCount = Math.max(cnt, maxCount);
        }

        if (maxCount >= 3) {
            return "Three of a Kind";
        } else if (maxCount == 2) {
            return "Pair";
        }

        return "High Card";
    }
}
