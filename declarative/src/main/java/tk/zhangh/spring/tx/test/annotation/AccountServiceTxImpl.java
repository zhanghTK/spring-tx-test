package tk.zhangh.spring.tx.test.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.zhangh.spring.tx.test.bean.AccountDao;
import tk.zhangh.spring.tx.test.bean.AccountService;

/**
 * Created by ZhangHao on 2017/9/15.
 */
public class AccountServiceTxImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(String from, String to, Double amount) {
        accountDao.turnOut(from, amount);
        int i = 1 / 0;
        accountDao.turnIn(to, amount);
    }
}
