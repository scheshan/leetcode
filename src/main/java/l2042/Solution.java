package l2042;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/3
 */
public class Solution {

    public boolean areNumbersAscending(String s) {
        int lastNumber = 0;
        int curNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                if (curNumber != 0) {
                    curNumber = curNumber * 10;
                }
                curNumber += (ch - '0');
            } else {
                if (curNumber != 0) {
                    if (curNumber <= lastNumber) {
                        return false;
                    }

                    lastNumber = curNumber;
                    curNumber = 0;
                }
            }
        }

        if (curNumber != 0 && curNumber <= lastNumber) {
            return false;
        }

        return true;
    }
}
