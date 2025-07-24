package com.hq.acdm.controller.exception;

import com.hq.acdm.exception.LinkNotFoundException;
import com.hq.acdm.exception.LoginExpireException;
import com.hq.acdm.exception.PermissionException;
import com.hq.acdm.exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LiFaQiang
 * @date 2018/12/05 14:34
 * @Description
 */
@Controller
public class CustomExceptionController {
    @RequestMapping("/404.json")
    public void unmappedRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
        throw new LinkNotFoundException();
    }

    @RequestMapping("/500.json")
    public void handlerFilterError(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        if(throwable instanceof LoginExpireException) {
            throw new LoginExpireException();
        }else if (throwable instanceof PermissionException) {
            throw new PermissionException();
        }else{
            throw new SystemException();
        }
    }
}
