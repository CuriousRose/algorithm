package leet_code.leet_code_0151_0200.leet_code_0185;

/**
 * 数据库 查询
 */
public class SQL {
    /**
     * select d.Name as Department,e.Name as Employee,e.Salary as Salary
     * from Department d left join Employee e
     * on d.Id = e.DepartmentId
     * where e.Salary >=
     *         (ifnull((select distinct Salary
     *             from Employee
     *             where DepartmentId =d.Id
     *             order by Salary desc
     *             limit 2,1),0))
     * order by e.DepartmentId,e.Salary desc
     */
}
