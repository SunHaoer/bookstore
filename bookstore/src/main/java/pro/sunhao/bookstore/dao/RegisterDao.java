package pro.sunhao.bookstore.dao;

import org.springframework.stereotype.Repository;
import pro.sunhao.bookstore.pojo.UserBase;

@Repository
public interface RegisterDao {

    Long selectUserByUserNameOrPhone(String inputStr);
}
