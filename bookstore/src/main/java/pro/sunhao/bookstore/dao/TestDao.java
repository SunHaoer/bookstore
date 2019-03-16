package pro.sunhao.bookstore.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pro.sunhao.bookstore.pojo.TestBase;
import pro.sunhao.bookstore.pojo.UserBase;

@Repository
public interface TestDao {

    /**
     * 根据username和password查user
     */
    public TestBase login(@Param("username") String username, @Param("password") String password);

}
