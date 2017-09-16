package tk.zhangh.spring.tx.test;

/**
 * Created by ZhangHao on 2017/9/15.
 */
public interface AccountDao {
    void turnOut(String id, Double amount);

    void turnIn(String id, Double amount);
}
