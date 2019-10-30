package leet_code.leet_code_0151_0200.leet_code_0182;

/**
 * 数据库 查询
 */
public class SQL {
    /**
     * select p.email as Email from
     * (select count(email)as count,email from person
     * group by email) as p
     * where p.count > 1;
     */

    /**
     * select Email from person
     * group by email
     * having count(*) > 1;
     */
}
