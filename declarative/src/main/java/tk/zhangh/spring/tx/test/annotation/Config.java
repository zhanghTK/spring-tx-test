package tk.zhangh.spring.tx.test.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by ZhangHao on 2017/9/17.
 */
@Configuration
@EnableTransactionManagement
public class Config {
    @Bean
    public AccountServiceTxImpl accountService() {
        return new AccountServiceTxImpl();
    }
}
