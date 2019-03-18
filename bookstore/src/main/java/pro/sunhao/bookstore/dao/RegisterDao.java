package pro.sunhao.bookstore.dao;

import org.springframework.stereotype.Repository;
import pro.sunhao.bookstore.pojo.UserBase;

@Repository
public interface RegisterDao {

    Long insertUser(UserBase user);

    Long selectUserByUserNameOrPhone(String inputStr);

}
