package tk.zhangh.spring.tx.test;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by ZhangHao on 2017/9/15.
 */
public interface AccountDao {
    void turnOut(String id, Double amount);

    void turnIn(String id, Double amount);

    class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
        @Override
        public void turnOut(String name, Double amount) {
            String sql = "update account set money = money - ? where name = ?";
            getJdbcTemplate().update(sql, amount, name);
        }

        @Override
        public void turnIn(String name, Double amount) {
            String sql = "update account set money = money + ? where name = ?";
            getJdbcTemplate().update(sql, amount, name);
        }
    }
}
