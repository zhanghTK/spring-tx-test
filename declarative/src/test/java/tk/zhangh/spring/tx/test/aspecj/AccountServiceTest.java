package tk.zhangh.spring.tx.test.aspecj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tk.zhangh.spring.tx.test.bean.AccountService;
import tk.zhangh.spring.tx.test.bean.BaseConfig;

/**
 * Created by ZhangHao on 2017/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations = "classpath:spring.xml", classes = BaseConfig.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test(expected = ArithmeticException.class)
    public void transfer() throws Exception {
        accountService.transfer("aaa", "bbb", 100D);
    }

}