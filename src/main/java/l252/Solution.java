package l252;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public boolean canAttendMeetings(int[][] intervals) {
        List<int[]> array = new ArrayList<>(intervals.length);
        for (int[] item : intervals) {
            array.add(item);
        }

        array.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i)[0] < array.get(i - 1)[1]) {
                return false;
            }
        }
        return true;
    }
}
