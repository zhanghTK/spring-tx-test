package tk.zhangh.spring.tx.test.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangHao on 2017/9/15.
 */
public interface AccountService {
    void transfer(String from, String to, Double amount);

    class AccountServiceImpl implements AccountService {

        @Autowired
        private AccountDao accountDao;

        @Override
        public void transfer(String from, String to, Double amount) {
            accountDao.turnOut(from, amount);
            int i = 1/0;
            accountDao.turnIn(to, amount);
        }
    }
}
