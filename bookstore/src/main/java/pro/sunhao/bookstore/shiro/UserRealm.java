package pro.sunhao.bookstore.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.sunhao.bookstore.dao.LoginDao;
import pro.sunhao.bookstore.pojo.UserBase;
import pro.sunhao.bookstore.service.LoginService;

@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private LoginDao loginDao;

    /**
     * 获得权限控制
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        return null;
    }

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken loginToken = (UsernamePasswordToken)authenticationToken;
//        System.out.println(loginToken);
//        String username = loginToken.getUsername();
//        UserBase user = loginDao.selectUserByUsername(username);
//        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUserPassword(), user.getUserUsername());
        System.out.println("认证");
        return null;
    }
}
