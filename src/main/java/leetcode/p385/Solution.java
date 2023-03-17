package leetcode.p385;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/17
 */
public class Solution {

    private int ind;

    public NestedInteger deserialize(String s) {
        return read(s);
    }

    private NestedInteger read(String s) {
        if (s.charAt(ind) == '[') {
            return readList(s);
        } else {
            return readInt(s);
        }
    }

    private NestedInteger readList(String s) {
        NestedInteger res = new NestedInteger();
        ind++;
        while (ind < s.length() && s.charAt(ind) != ']') {
            if (s.charAt(ind) == ',') {
                ind++;
            }
            res.add(read(s));
        }
        ind++;
        return res;
    }

    private NestedInteger readInt(String s) {
        NestedInteger res = new NestedInteger();
        int n = 0;
        boolean positive = true;
        if (s.charAt(ind) == '-') {
            positive = false;
            ind++;
        }

        while (ind < s.length() && Character.isDigit(s.charAt(ind))) {
            n = n * 10 + s.charAt(ind) - '0';
            ind++;
        }

        res.setInteger(positive ? n : -n);
        return res;
    }
}
