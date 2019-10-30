package leet_code.leet_code_0151_0200.leet_code_0180;

/**
 * 数据库 查询
 */
public class SQL {
    /**
     * # Write your MySQL query statement below
     * select distinct l.num as ConsecutiveNums
     * from Logs l
     * where l.num = (select num from logs where id = l.id-1)
     * and l.num = (select num from logs where id = l.id+1);
     */

    /**
     * select distinct a.num as ConsecutiveNums from
     * logs a, logs b, logs c
     * where a.num = b.num and a.num = c.num
     * and a.id = b.id+1 and a.id = c.id-1;
     */

    /**
     * select distinct Num as ConsecutiveNums
     * from (
     *   select Num,
     *     case
     *       when @prev = Num then @count := @count + 1
     *       when (@prev := Num) is not null then @count := 1
     *     end as CNT
     *   from Logs, (select @prev := null,@count := null) as t
     * ) as temp
     * where temp.CNT >= 3
     */
}
