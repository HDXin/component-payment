package top.atstudy.component.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import top.atstudy.component.auth.vo.SessionUser;
import top.atstudy.component.base.config.AuthToken;
import top.atstudy.component.base.config.Constants;
import top.atstudy.component.base.config.SelfConfig;
import top.atstudy.component.base.util.BeanUtils;
import top.atstudy.component.exception.APIException;
import top.atstudy.component.payment.base.enums.Unauthorized;
import top.atstudy.component.payment.config.dao.IPaymentConfigDao;
import top.atstudy.component.payment.config.dao.dto.PaymentConfigDTO;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: hdxin
 * Date: 2018-07-09
 * Time: 17:21
 */
public class AuthInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Autowired
    private IPaymentConfigDao paymentConfigDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info(" ===>> auth preHandle ...");
        if(checkAuth(request, response))
            return true;

        throw new APIException(Unauthorized.UNAUTHORIZED);
    }

    private boolean checkAuth(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get token string from cookie
        String tokenString = getTokenString(request);

        if (tokenString == null) {
            logger.warn("Not found authToken in cookie");
            return false;
        }

        // parse AuthToken
        AuthToken authToken = null;
        try {
            authToken = AuthToken.parse(tokenString);
        } catch (Exception e) {
            logger.error("Failed decrypt token: {}, exception: {}", tokenString, e.getMessage());
            return false;
        }

        //判断是否有效
        if (AuthToken.isActive(authToken)) {
            if (paymentConfigDao == null) {//解决service为null无法注入问题
                BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                paymentConfigDao = factory.getBean(IPaymentConfigDao.class);
                if(paymentConfigDao == null){
                    logger.info("paymentConfigDao is null ... ");
                    return false;
                }
            }
            //获取项目配置
            PaymentConfigDTO target = paymentConfigDao.getById(authToken.userId);
            if(target == null || target.getId() == null){
                logger.info("paymentConfig is null ... ");
                return false;
            }

            //将放入请求预中
            SessionUser sessionUser = BeanUtils.copyProperties(target, SessionUser.class);
            request.setAttribute(Constants.SESSION_USER_KEY, sessionUser);
            return true;
        }

        logger.warn("authToken cookie expired: {}={}", Constants.AUTH_TOKEN_NAME, authToken.token());
        return false;
    }

    protected String getTokenString(HttpServletRequest httpRequest) {
        // from querystring
        String tokenString = httpRequest.getParameter(Constants.AUTH_TOKEN_NAME_DEFAULT);

        // from header
        if (StringUtils.isBlank(tokenString)) {
            tokenString = httpRequest.getHeader(Constants.AUTH_TOKEN_NAME_DEFAULT);
        }

        // from cookie
        if (httpRequest.getCookies() != null) {
            for (Cookie c : httpRequest.getCookies()) {
                if (Constants.AUTH_TOKEN_NAME.equals(c.getName())) {
                    tokenString = c.getValue();
                    break;
                }
                if (Constants.AUTH_TOKEN_NAME_DEFAULT.equals(c.getName())) {
                    tokenString = c.getValue();
                    break;
                }
            }
        }

        return tokenString;
    }
}
