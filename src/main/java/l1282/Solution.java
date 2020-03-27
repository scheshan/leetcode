package l1282;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/27
 */
public class Solution {

    private class User {

        private int id;

        private int size;

        public User(int id, int size) {
            this.id = id;
            this.size = size;
        }
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<User> users = new ArrayList<>(groupSizes.length);
        for (int i = 0; i < groupSizes.length; i++) {
            User user = new User(i, groupSizes[i]);
            users.add(user);
        }

        users.sort(Comparator.comparingInt(o -> o.size));

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> group = new LinkedList<>();
        int size = 0;
        for (User user : users) {
            if (size == 0) {
                size = user.size;
                group.add(user.id);
            } else {
                group.add(user.id);
            }

            if (group.size() >= size) {
                res.add(group);
                size = 0;
                group = new LinkedList<>();
            }
        }

        if (group.size() > 0) {
            res.add(group);
        }

        return res;
    }
}
