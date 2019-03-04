package pro.sunhao.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.mapper.TestDao;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao test;

    public boolean test(String username, String password) {
        if(test.login(username, password) != null) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }
        return false;
    }

}
