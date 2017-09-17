package tk.zhangh.spring.tx.test.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ZhangHao on 2017/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Config.class)
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void transfer() throws Exception {
        accountService.transfer("aaa", "bbb", 100D);
    }
}