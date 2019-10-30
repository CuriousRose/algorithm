package leet_code.leet_code_0251_0300.leet_code_0262;

/**
 * @author chj
 * @date 2019/8/7 10:40
 * join round if
 * 11:16
 */
public class SQL {
    /**
     * select
     *     Trips.Request_at Day,
     *     (
     *         round(
     *             count(if(Trips.Status != 'completed',1,null)) / count(Trips.Status)
     *         ,2)
     *     )
     *     as 'Cancellation Rate'
     * from
     * Trips left join Users
     * on Trips.Client_Id  = Users.Users_Id
     * where Trips.Request_at >= '2013-10-01'
     * and Trips.Request_at <= '2013-10-03'
     * and Users.Banned  = 'No'
     * group by Trips.Request_at;
     */
}
