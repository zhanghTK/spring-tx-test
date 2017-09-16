package tk.zhangh.spring.tx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ZhangHao on 2017/9/15.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        AccountService service = applicationContext.getBean(AccountService.class);
        service.transfer("aaa", "bbb", 200d);
    }
}
