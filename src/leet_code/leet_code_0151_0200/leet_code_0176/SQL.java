package leet_code.leet_code_0151_0200.leet_code_0176;

/**
 * 数据库 查询
 */
public class SQL {
    /**
     * select
     *     IFNULL(
     *         (select distinct Salary
     *         from Employee
     *         order by Salary desc
     *         limit 1 offset 1),
     *         null
     *     )
     *     as SecondHighestSalary;
     */
}
