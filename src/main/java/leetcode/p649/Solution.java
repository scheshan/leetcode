package leetcode.p649;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public String predictPartyVictory(String senate) {
        int n1 = 0, n2 = 0, v1 = 0, v2 = 0;

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                n1++;
            } else {
                n2++;
            }
            queue.add(senate.charAt(i));
        }

        while (n1 > 0 && n2 > 0) {
            char ch = queue.remove();
            if (ch == 'R') {
                if (v2 > 0) {
                    n1--;
                    v2--;
                } else {
                    v1++;
                    queue.add(ch);
                }
            } else {
                if (v1 > 0) {
                    n2--;
                    v1--;
                } else {
                    v2++;
                    queue.add(ch);
                }
            }
        }

        return n1 > 0 ? "Radiant" : "Dire";
    }
}
