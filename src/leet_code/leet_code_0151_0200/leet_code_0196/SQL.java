package leet_code.leet_code_0151_0200.leet_code_0196;

/**
 * 数据库 删除
 */
public class SQL {
    /**
     * delete from person where id not in
     * (select Id from (select MIN(id) as id from person group by email) t);
     */
}
