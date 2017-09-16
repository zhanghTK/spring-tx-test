package tk.zhangh.spring.tx.test;

import lombok.Data;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by ZhangHao on 2017/9/15.
 */
@Data
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void transfer(String from, String to, Double amount) {
        TransactionTemplate transactionTemplate = TransactionTemplateUtils.transactionTemplate();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.turnOut(from, amount);
                accountDao.turnIn(to, amount);
            }
        });
    }
}
