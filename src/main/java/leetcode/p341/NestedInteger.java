package leetcode.p341;

import java.util.List;

/**
 * NestedInteger
 *
 * @author heshan
 * @date 2023/2/2
 */
public interface NestedInteger {

    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}
