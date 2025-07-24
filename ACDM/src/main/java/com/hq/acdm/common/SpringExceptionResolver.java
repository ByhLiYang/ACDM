package com.hq.acdm.common;

import com.hq.acdm.exception.LinkNotFoundException;
import com.hq.acdm.exception.LoginExpireException;
import com.hq.acdm.exception.ParamException;
import com.hq.acdm.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: lizhifeng
 * @Date: 2018/8/18
 * @Description:
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {
    /**
     * 项目中所有请求json数据的URL，都使用.json结尾
     */
    private static final String STR = ".json";
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String url = request.getRequestURL().toString();
        ModelAndView mv;

        if (url.endsWith(STR)) {
            if (ex instanceof PermissionException) {
                ServerResponse result = ServerResponse.createByNotPermission();
                mv = new ModelAndView("jsonView", result.toMap());
            } else if (ex instanceof LinkNotFoundException) {
                ServerResponse result = ServerResponse.createByNotFoundError();
                mv = new ModelAndView("jsonView", result.toMap());
            } else if (ex instanceof NullPointerException) {
                ServerResponse result = ServerResponse.createByNullPointerError();
                mv = new ModelAndView("jsonView", result.toMap());
            } else if (ex instanceof ParamException) {
                ServerResponse result = ServerResponse.createByParamError(ex.getMessage());
                mv = new ModelAndView("jsonView", result.toMap());
            } else if (ex instanceof LoginExpireException) {
                ServerResponse result = ServerResponse.createByLoginExpire();
                mv = new ModelAndView("jsonView", result.toMap());
            } else {
                log.error("unknown json exception, url:" + url, ex);
                ServerResponse result = ServerResponse.createBySystemError();
                mv = new ModelAndView("jsonView", result.toMap());
            }
        }  else {
            log.error("unknown exception, url:" + url, ex);
            ServerResponse result = ServerResponse.createBySuccessMessage(ex.getMessage());
            mv = new ModelAndView("jsonView", result.toMap());
        }

        return mv;
    }
}
