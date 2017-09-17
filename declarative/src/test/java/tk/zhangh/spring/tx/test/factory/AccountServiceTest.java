package tk.zhangh.spring.tx.test.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by ZhangHao on 2017/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Resource(name = "accountServiceProxy")
    private AccountService accountService;

    @Test
    public void transfer() throws Exception {
        accountService.transfer("aaa", "bbb", 100D);
    }

}