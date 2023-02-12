package leetcode.p2284;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/12
 */
public class Solution {

    public String largestWordCount(String[] messages, String[] senders) {
        int max = 0;
        String res = null;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String sender = senders[i];
            int cnt = map.getOrDefault(sender, 0);

            String message = messages[i];
            int ind = 0;
            while (ind < message.length()) {
                while (ind < message.length() && message.charAt(ind) != ' ') {
                    ind++;
                }

                cnt++;
                ind++;
            }

            if (cnt > max) {
                max = cnt;
                res = sender;
            } else if (cnt == max) {
                if (res.compareTo(sender) < 0) {
                    res = sender;
                }
            }
            map.put(sender, cnt);
        }
        return res;
    }
}
