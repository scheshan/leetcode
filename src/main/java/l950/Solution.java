package l950;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/15
 */
public class Solution {

    public int[] deckRevealedIncreasing(int[] deck) {
        LinkedList<Integer> list = new LinkedList<>();

        Arrays.sort(deck);

        for (int i = deck.length - 1; i >= 0; i--) {
            int n = deck[i];
            if (list.isEmpty()) {
                list.addLast(n);
            } else {
                list.addFirst(list.removeLast());
                list.addFirst(n);
            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (int n : list) {
            res[i++] = n;
        }
        return res;
    }
}
