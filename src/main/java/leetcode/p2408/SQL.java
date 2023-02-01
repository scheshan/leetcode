package leetcode.p2408;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SQL
 *
 * @author heshan
 * @date 2023/2/1
 */
public class SQL {

    private class Table {
        private int columns;

        private int nextId;

        private Map<Integer, String[]> data;

        public Table(int columns) {
            this.columns = columns;
            this.data = new HashMap<>();
        }

        private void insert(List<String> row) {
            int id = ++nextId;
            String[] arr = new String[row.size()];
            int ind = 0;
            for (String str : row) {
                arr[ind++] = str;
            }
            data.put(id, arr);
        }

        private void delete(int rowId) {
            data.remove(rowId);
        }

        private String select(int rowId, int columnId) {
            return data.get(rowId)[columnId - 1];
        }
    }

    private Map<String, Table> tables;

    public SQL(List<String> names, List<Integer> columns) {
        tables = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            Table tbl = new Table(columns.get(i));
            tables.put(names.get(i), tbl);
        }
    }

    public void insertRow(String name, List<String> row) {
        tables.get(name).insert(row);
    }

    public void deleteRow(String name, int rowId) {
        tables.get(name).delete(rowId);
    }

    public String selectCell(String name, int rowId, int columnId) {
        return tables.get(name).select(rowId, columnId);
    }
}
