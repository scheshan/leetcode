package l8;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/3
 */
public class Solution {

    private State current;

    private State start = new StartState();

    private State number = new NumberState();

    private State end = new EndState();

    private int index;

    private boolean negative;

    private int res;

    public int myAtoi(String str) {
        current = start;

        while (index < str.length() && current != end) {
            current.read(str);
        }

        return negative ? -1 * res : res;
    }

    private interface State {

        void read(String str);
    }

    private class StartState implements State {

        @Override
        public void read(String str) {
            if (str.charAt(index) == ' ') {
                index++;
            } else if (str.charAt(index) == '-' || str.charAt(index) == '+') {
                negative = str.charAt(index) == '-';
                index++;
                current = number;
            } else if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                current = number;
            } else {
                current = end;
            }
        }
    }

    private class NumberState implements State {

        @Override
        public void read(String str) {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                int t = str.charAt(index) - '0';

                if (!negative && res > (Integer.MAX_VALUE - t) / 10) {
                    res = Integer.MAX_VALUE;
                    current = end;
                    return;
                }

                if (negative && res > (-1 * (Integer.MIN_VALUE + 1) - t) / 10) {
                    res = Integer.MIN_VALUE;
                    current = end;
                    return;
                }

                res = res * 10 + t;
                index++;
            } else {
                current = end;
            }
        }
    }

    private class EndState implements State {

        @Override
        public void read(String str) {

        }
    }

    public static void main(String[] args) {
        new Solution().myAtoi("42");
    }
}
