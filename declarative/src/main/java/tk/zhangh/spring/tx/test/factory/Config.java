package tk.zhangh.spring.tx.test.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;
import tk.zhangh.spring.tx.test.bean.AccountService;
import tk.zhangh.spring.tx.test.bean.BaseConfig;

import java.util.Properties;

/**
 * Created by ZhangHao on 2017/9/17.
 */
@Configuration
public class Config {

    @Autowired
    private BaseConfig baseConfig;

    @Bean
    public TransactionProxyFactoryBean accountServiceProxy(AccountService accountService) {
        TransactionProxyFactoryBean transactionProxyFactoryBean = new TransactionProxyFactoryBean();
        transactionProxyFactoryBean.setTarget(accountService);
        transactionProxyFactoryBean.setTransactionManager(baseConfig.dataSourceTransactionManager(baseConfig.dataSource()));
        Properties properties = new Properties();
        // 格式：key = "save*", value = "事务传播行为,事务隔离级别，只读，发生哪些异常回滚事务，发生哪些异常不回滚事务"
//        properties.put("transfer", "PROPAGATION_REQUIRED,+java.lang.ArithmeticException");
        properties.put("transfer", "PROPAGATION_REQUIRED");
        transactionProxyFactoryBean.setTransactionAttributes(properties);
        return transactionProxyFactoryBean;
    }
}
