package leetcode.p1381;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class CustomStack {

    int[] arr;
    int ind;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
    }

    public void push(int x) {
        if (ind < arr.length) {
            arr[ind++] = x;
        }
    }

    public int pop() {
        if (ind > 0) {
            return arr[--ind];
        }
        return -1;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, ind); i++) {
            arr[i] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
    }
}
