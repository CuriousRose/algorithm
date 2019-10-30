package leet_code.leet_code_0151_0200.leet_code_0177;

/**
 * 数据库 查询 函数
 */
public class SQL {
    /**
     * CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
     * BEGIN
     *   heap N = N-1;
     *   RETURN (
     *       # Write your MySQL query statement below.
     *       select distinct Salary from Employee order by Salary desc limit N,1
     *   );
     * END
     */
}
