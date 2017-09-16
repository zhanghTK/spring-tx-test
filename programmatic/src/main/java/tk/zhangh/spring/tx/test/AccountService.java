package tk.zhangh.spring.tx.test;

/**
 * Created by ZhangHao on 2017/9/15.
 */
public interface AccountService {
    void transfer(String from, String to, Double amount);
}
