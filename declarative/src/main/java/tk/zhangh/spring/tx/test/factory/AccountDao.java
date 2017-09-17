package tk.zhangh.spring.tx.test.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangHao on 2017/9/15.
 */
public interface AccountDao {
    void turnOut(String name, Double amount);

    void turnIn(String name, Double amount);

    @Component
    class AccountDaoImpl implements AccountDao {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Override
        public void turnOut(String name, Double amount) {
            String sql = "update account set money = money - ? where name = ?";
            jdbcTemplate.update(sql, amount, name);
        }

        @Override
        public void turnIn(String name, Double amount) {
            String sql = "update account set money = money + ? where name = ?";
            jdbcTemplate.update(sql, amount, name);
        }
    }
}
