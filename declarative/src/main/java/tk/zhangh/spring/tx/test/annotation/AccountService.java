package tk.zhangh.spring.tx.test.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZhangHao on 2017/9/15.
 */
public interface AccountService {
    void transfer(String from, String to, Double amount);

    @Component
    class AccountServiceImpl1 implements AccountService {

        @Autowired
        private AccountDao accountDao;

        @Override
        @Transactional
        public void transfer(String from, String to, Double amount) {
            accountDao.turnOut(from, amount);
            int i = 1/0;
            accountDao.turnIn(to, amount);
        }
    }
}
