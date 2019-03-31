package pro.sunhao.bookstore.dao;

import org.springframework.stereotype.Repository;
import pro.sunhao.bookstore.pojo.UserBase;

@Repository
public interface LoginDao {

    UserBase selectUserByUsernameAndPassword(String username, String password);

}
