package tk.zhangh.spring.tx.test.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by ZhangHao on 2017/9/17.
 */
@Configuration
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
    public TransactionProxyFactoryBean accountServiceProxy(AccountService accountService) {
        TransactionProxyFactoryBean transactionProxyFactoryBean = new TransactionProxyFactoryBean();
        transactionProxyFactoryBean.setTarget(accountService);
        transactionProxyFactoryBean.setTransactionManager(dataSourceTransactionManager(dataSource()));
        Properties properties = new Properties();
        // 格式：key = "save*", value = "事务传播行为,事务隔离级别，只读，发生哪些异常回滚事务，发生哪些异常不回滚事务"
        properties.put("transfer", "PROPAGATION_REQUIRED,+java.lang.ArithmeticException");
        transactionProxyFactoryBean.setTransactionAttributes(properties);
        return transactionProxyFactoryBean;
    }
}
