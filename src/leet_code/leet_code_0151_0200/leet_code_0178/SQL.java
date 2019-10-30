package leet_code.leet_code_0151_0200.leet_code_0178;

/**
 * 数据库 排序
 */
public class SQL {
    /**
     * select score,
     *     (select count(distinct score)
     *      from scores where score >= s.score) as Rank
     * from scores s order by score desc;
     */

    /**
     * select s1.score,count(distinct s2.score) as Rank
     * from scores s1 join scores s2
     * on s1.score <= s2.score
     * group by s1.Id
     * order by Rank
     */
}
