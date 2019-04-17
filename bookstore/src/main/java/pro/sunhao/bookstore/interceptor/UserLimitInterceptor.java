package pro.sunhao.bookstore.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pro.sunhao.bookstore.info.ControllerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLimitInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(1);
        int userLimit = 0;
        if(request.getSession().getAttribute("loginUser") != null) {
            String loginUser = request.getSession().getAttribute("loginUser").toString();
            if(loginUser.equals("admin")) {
                userLimit = 2;
            } else {
                userLimit = 1;
            }
        }

        String requestUri = request.getRequestURI();
        if(requestUri.startsWith(ControllerMapping.ADDPRODUCT) || requestUri.startsWith(ControllerMapping.MANAGEPRODUCT)) {    // 管理员
            if(userLimit < 2) {
                response.sendRedirect(ControllerMapping.LOGIN + "/notLimit");
                //return false;
            }
        } else if(requestUri.startsWith(ControllerMapping.CART)) {    // 普通用户权限
            if(userLimit < 1) {
                response.sendRedirect(ControllerMapping.LOGIN + "/notLimit");
                //return false;
            }
        }

        System.out.println(1.5);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        System.out.println(2);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        System.out.println(3);
    }

}
