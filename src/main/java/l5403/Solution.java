package l5403;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/3
 */
public class Solution {

    public int kthSmallest(int[][] mat, int k) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][0];
        }

        if (k == 1) {
            return sum;
        }
        k--;

        Queue<Item> queue = new PriorityQueue<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.total - o2.total;
            }
        });

        Set<String> visit = new HashSet<>();
        Item first = new Item(new int[mat.length], sum);
        visit.add(Arrays.toString(first.pick));
        queue.add(first);

        while (k > 0) {
            k--;

            Item item = queue.remove();
            for (int i = 0; i < mat.length; i++) {
                item.pick[i]++;

                if (item.pick[i] < mat[i].length && !visit.contains(Arrays.toString(item.pick))) {
                    visit.add(Arrays.toString(item.pick));
                    int[] pick = Arrays.copyOf(item.pick, item.pick.length);

                    int total = item.total - mat[i][item.pick[i] - 1] + mat[i][item.pick[i]];
                    queue.add(new Item(pick, total));
                }

                item.pick[i]--;
            }
        }

        return queue.peek().total;
    }

    private class Item {

        private int[] pick;

        private int total;

        public Item(int[] pick, int total) {
            this.pick = pick;
            this.total = total;
        }
    }

    public static void main(String[] args) {
        int res = new Solution().kthSmallest(new int[][]{
                new int[]{1, 3, 11},
                new int[]{2, 4, 6}
        }, 5);
        System.out.println(res);
    }
}
