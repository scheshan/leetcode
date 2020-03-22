package l520;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public boolean detectCapitalUse(String word) {
        boolean firstUpper = false;
        int uppers = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                uppers++;
                if (i == 0) {
                    firstUpper = true;
                }
            }
        }

        if (firstUpper) {
            return uppers == 1 || uppers == word.length();
        } else {
            return uppers == 0;
        }
    }
}
