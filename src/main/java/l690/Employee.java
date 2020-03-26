package l690;

import java.util.List;

/**
 * Employee
 *
 * @author heshan
 * @date 2020/3/26
 */
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
