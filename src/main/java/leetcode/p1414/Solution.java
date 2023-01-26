package leetcode.p1414;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int findMinFibonacciNumbers(int k) {
        int n1 = 1;
        int n2 = 2;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(n1);
        deque.addLast(n2);

        while (true) {
            int n = n1 + n2;
            if (n > k) {
                break;
            }
            deque.addLast(n);
            n1 = n2;
            n2 = n;
        }

        int res = 0;
        while (k > 0) {
            if (deque.peekLast() > k) {
                deque.removeLast();
            } else {
                k -= deque.peekLast();
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().findMinFibonacciNumbers(19);
    }
}
