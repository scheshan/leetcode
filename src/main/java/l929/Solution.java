package l929;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/28
 */
public class Solution {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(getName(email));
        }

        return set.size();
    }

    private String getName(String email) {
        StringBuilder sb = new StringBuilder();

        int middle = email.indexOf('@');
        for (int i = 0; i < middle; i++) {
            char ch = email.charAt(i);
            if (ch == '.') {
                continue;
            } else if (ch == '+') {
                break;
            }
            sb.append(ch);
        }
        sb.append(email, middle, email.length());
        return sb.toString();
    }
}
