package interview.p03_01;

/**
 * TripleInOne
 *
 * @author heshan
 * @date 2023/2/1
 */
public class TripleInOne {

    private int[] arr;

    private Stack[] stacks;

    private class Stack {
        private int base;
        private int capacity;
        private int tail;

        public Stack(int base, int size) {
            this.base = base;
            this.capacity = size;
            this.tail = base;
        }

        public void push(int value) {
            if (tail == base + capacity) {
                return;
            }
            arr[tail++] = value;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            return arr[--tail];
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return arr[tail - 1];
        }

        public boolean isEmpty() {
            return tail == base;
        }
    }

    public TripleInOne(int stackSize) {
        arr = new int[stackSize * 3];
        stacks = new Stack[3];
        stacks[0] = new Stack(0, stackSize);
        stacks[1] = new Stack(stackSize, stackSize);
        stacks[2] = new Stack(stackSize + stackSize, stackSize);
    }

    public void push(int stackNum, int value) {
        stacks[stackNum].push(value);
    }

    public int pop(int stackNum) {
        return stacks[stackNum].pop();
    }

    public int peek(int stackNum) {
        return stacks[stackNum].peek();
    }

    public boolean isEmpty(int stackNum) {
        return stacks[stackNum].isEmpty();
    }
}
