package l1396;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/15
 */
public class UndergroundSystem {

    private Map<Integer, Tuple<String, Integer>> userMap;

    private Map<Stations, Tuple<Long, Long>> statisticsMap;

    public UndergroundSystem() {
        userMap = new HashMap<>();
        statisticsMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if (userMap.containsKey(id)) {
            return;
        }

        Tuple<String, Integer> tuple = new Tuple<>();
        tuple.t1 = stationName;
        tuple.t2 = t;

        userMap.put(id, tuple);
    }

    public void checkOut(int id, String stationName, int t) {
        Tuple<String, Integer> tuple = userMap.remove(id);
        if (tuple == null) {
            return;
        }

        Stations key = new Stations(tuple.t1, stationName);
        Tuple<Long, Long> statistics = statisticsMap.get(key);
        if (statistics == null) {
            statistics = new Tuple<>();
            statistics.t1 = 0L;
            statistics.t2 = 0L;
            statisticsMap.put(key, statistics);
        }

        statistics.t1++;
        statistics.t2 += t - tuple.t2;
    }

    public double getAverageTime(String startStation, String endStation) {
        Stations key = new Stations(startStation, endStation);
        Tuple<Long, Long> statistics = statisticsMap.get(key);
        if (statistics == null) {
            return 0;
        }

        return statistics.t2 * 1.0 / statistics.t1;
    }

    private class Stations {

        String start;

        String end;

        public Stations(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Stations stations = (Stations) o;
            return Objects.equals(start, stations.start) &&
                    Objects.equals(end, stations.end);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    private class Tuple<T1, T2> {

        T1 t1;

        T2 t2;
    }
}
