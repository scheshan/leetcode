package l393;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/3
 */
public class Solution {

    private int index;

    private State current;

    private State start = new StartState();

    private State wrong = new WrongState();

    private State normal2 = new NormalState(2);

    private State normal3 = new NormalState(3);

    private State normal4 = new NormalState(4);

    public boolean validUtf8(int[] data) {
        current = start;

        while (index < data.length && current != wrong) {
            current.read(data);
        }

        return current != wrong;
    }

    private interface State {

        void read(int[] data);
    }

    private class StartState implements State {

        @Override
        public void read(int[] data) {
            if (data[index] >> 7 == 0) {
                index++;
            } else if (data[index] >> 5 == 6) {
                current = normal2;
            } else if (data[index] >> 4 == 14) {
                current = normal3;
            } else if (data[index] >> 3 == 30) {
                current = normal4;
            } else {
                current = wrong;
            }
        }
    }

    private class WrongState implements State {

        @Override
        public void read(int[] data) {

        }
    }

    private class NormalState implements State {

        int length;

        public NormalState(int length) {
            this.length = length;
        }

        @Override
        public void read(int[] data) {
            if (index + length > data.length) {
                current = wrong;
                return;
            }

            index++;
            for (int i = 1; i < length; i++) {
                if (data[index++] >> 6 != 2) {
                    current = wrong;
                    return;
                }
            }

            current = start;
        }
    }

    public static void main(String[] args) {
        new Solution().validUtf8(new int[]{197, 130, 1});
    }
}