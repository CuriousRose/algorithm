package leet_code.leet_code_0151_0200.leet_code_0184;

/**
 * 数据库 查询
 */
public class SQL {
    /**
     * select d.name as Department,e.name as Employee,e.salary as Salary
     * from Department d inner join Employee e
     * on d.id = e.DepartmentId
     * and e.salary >= (select max(salary) from employee where DepartmentId = d.id)
     */

    /**
     * select d.name as Department,e.name as Employee,e.salary as Salary
     * from Department d left join Employee e
     * on d.id = e.DepartmentId
     * where (e.Salary,e.DepartmentId) in
     * (select max(Salary) as Salary, DepartmentId
     * from Employee
     * group by DepartmentId )
     */
}
