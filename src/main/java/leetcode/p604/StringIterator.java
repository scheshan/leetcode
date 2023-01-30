package leetcode.p604;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class StringIterator {

    private String str;

    private int ind;

    private char ch;

    private int cnt;

    public StringIterator(String compressedString) {
        this.str = compressedString;
    }

    public char next() {
        if (cnt == 0 && ind < str.length()) {
            char ch = str.charAt(ind++);
            int c = 0;
            while (ind < str.length() && str.charAt(ind) >= '0' && str.charAt(ind) <= '9') {
                c = c * 10 + str.charAt(ind) - '0';
                ind++;
            }
            this.ch = ch;
            this.cnt = c;
        }

        if (cnt > 0) {
            cnt--;
            return ch;
        }

        return ' ';
    }

    public boolean hasNext() {
        return ind < str.length() || cnt > 0;
    }
}
