package leetcode.p929;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/6
 */
public class Solution {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(trim(email));
        }
        return set.size();
    }

    private String trim(String email) {
        StringBuilder sb = new StringBuilder(email.length());

        int ind = 0;
        boolean hasPlus = false;
        while (ind < email.length() && email.charAt(ind) != '@') {
            if (email.charAt(ind) == '+') {
                hasPlus = true;
            }
            if (!hasPlus) {
                if (email.charAt(ind) != '.') {
                    sb.append(email.charAt(ind));
                }
            }
            ind++;
        }

        while (ind < email.length()) {
            sb.append(email.charAt(ind));
            ind++;
        }
        return sb.toString();
    }
}
