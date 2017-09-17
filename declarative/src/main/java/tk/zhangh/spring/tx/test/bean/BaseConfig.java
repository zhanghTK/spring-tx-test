package tk.zhangh.spring.tx.test.bean;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ZhangHao on 2017/9/17.
 */
@Configuration
public class BaseConfig {
    @Bean
    public DataSource dataSource() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = this.getClass().getResourceAsStream("/application.properties");
            properties.load(inputStream);
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(properties.getProperty("jdbc.driverClass"));
            dataSource.setJdbcUrl(properties.getProperty("jdbc.url"));
            dataSource.setUser(properties.getProperty("jdbc.username"));
            dataSource.setPassword(properties.getProperty("jdbc.password"));
            return dataSource;
        } catch (PropertyVetoException | IOException e) {
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
        return new AccountService.AccountServiceImpl();
    }

    @Bean
    public AccountDao accountDao() {
        return new AccountDao.AccountDaoImpl();
    }
}
