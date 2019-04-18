package pro.sunhao.bookstore.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pro.sunhao.bookstore.info.ControllerMapping;
import pro.sunhao.bookstore.util.OperateJson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class UserLimitInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //response.sendRedirect(request.getContextPath() + "/" + ControllerMapping.LOGIN + "/notLimit");
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

        } else if(requestUri.startsWith(ControllerMapping.CART)) {    // 普通用户权限

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

    private JSONObject getNotLimitResultModel() {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        OperateJson.putMessage(outputJson, "not limit");
        return outputJson;
    }

}
