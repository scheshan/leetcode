package leetcode.p365;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/4
 */
public class Solution {

    private class State {

        private int n1;

        private int n2;

        public State(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return n1 == state.n1 && n2 == state.n2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n1, n2);
        }
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Set<State> visit = new HashSet<>();

        Queue<State> queue = new LinkedList<>();
        addQueue(queue, new State(0, 0), visit);

        while (!queue.isEmpty()) {
            State s = queue.remove();
            if (s.n1 == targetCapacity || s.n2 == targetCapacity || s.n1 + s.n2 == targetCapacity) {
                return true;
            }

            addQueue(queue, new State(jug1Capacity, s.n2), visit);
            addQueue(queue, new State(s.n1, jug2Capacity), visit);
            addQueue(queue, new State(0, s.n2), visit);
            addQueue(queue, new State(s.n1, 0), visit);

            if (s.n1 > 0 && s.n2 < jug2Capacity) {
                int n = Math.min(jug2Capacity - s.n2, s.n1);
                addQueue(queue, new State(s.n1 - n, s.n2 + n), visit);
            }
            if (s.n2 > 0 && s.n1 < jug1Capacity) {
                int n = Math.min(jug1Capacity - s.n1, s.n2);
                addQueue(queue, new State(s.n1 + n, s.n2 - n), visit);
            }
        }

        return false;
    }

    private void addQueue(Queue<State> queue, State state, Set<State> visit) {
        if (visit.contains(state)) {
            return;
        }
        visit.add(state);
        queue.add(state);
    }
}
