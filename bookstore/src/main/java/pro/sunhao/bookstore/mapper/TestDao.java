package pro.sunhao.bookstore.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pro.sunhao.bookstore.pojo.UserBase;

@Repository
public interface TestDao {

    /**
     * 根据username和password查user
     */
    public UserBase login(@Param("username") String username, @Param("password") String password);

}
