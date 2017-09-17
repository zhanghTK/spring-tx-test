package tk.zhangh.spring.tx.test.annotation;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by ZhangHao on 2017/9/17.
 */
@Configuration
@EnableTransactionManagement
public class Config {
    @Bean
    public DataSource dataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setUser("root");
            dataSource.setPassword("1");
            dataSource.setJdbcUrl("jdbc:mysql://zh-home.tk:3306/test");
            return dataSource;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public AccountService accountService() {
        return new AccountService.AccountServiceImpl1();
    }

    @Bean
    public AccountDao accountDao() {
        return new AccountDao.AccountDaoImpl1();
    }
}
