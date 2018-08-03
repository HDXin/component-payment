package top.atstudy.component.base.controller;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.atstudy.component.auth.vo.SessionUser;
import top.atstudy.component.base.config.AuthToken;
import top.atstudy.component.base.config.Constants;
import top.atstudy.component.base.util.RandUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: hdxin
 * Date: 2018-07-12
 * Time: 20:08
 */
public abstract class BasicController {
    protected SessionUser getSessionUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        SessionUser sessionUser = (SessionUser) request.getAttribute(Constants.SESSION_USER_KEY);
        if(sessionUser == null || sessionUser.getOperationId() == null){
            sessionUser = new SessionUser();
            sessionUser.setId(-99L);
            sessionUser.setProjectName("admin");
        }
        return sessionUser;
    }

    protected AuthToken createToken(Long userId, String userName) {
        long age = Constants.AUTH_TOKEN_AGE_MAX;
        // set authToken cookie
        final long now = System.currentTimeMillis();
        final long expiry = now + age * 1000;
        return new AuthToken(userId, userName, now, expiry, RandUtil.rand());
    }
}
