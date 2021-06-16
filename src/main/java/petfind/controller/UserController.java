package petfind.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petfind.exception.BusinessException;
import petfind.exception.BusinessExceptionCode;
import petfind.req.UserLoginReq;
import petfind.resp.CommonResp;
import petfind.resp.UserLoginResp;
import petfind.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/9 下午5:19
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    private static final Logger LOG= LoggerFactory.getLogger(UserController.class);

    /**
     * 登录接口
     * @param req
     * @param request
     * @return
     */
    @PostMapping("login")
    public CommonResp login(@Valid @RequestBody UserLoginReq req, HttpServletRequest request) {
        HttpSession session = request.getSession();

        UserLoginResp login = userService.login(req);
        if (login==null) {
            throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
        }
        session.setAttribute("user",login);
        UserLoginResp sessionUser = (UserLoginResp) session.getAttribute("user");
        LOG.info("session中存储的数据为:{}",sessionUser.getLoginname());

        CommonResp commonResp = new CommonResp();
        commonResp.setContent(login);
        return commonResp;
    }


    /**
     * 登出接口
     * 登出接口只需要使 session 失效就ok了
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public CommonResp logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        /**
         * session 失效
         */
        session.invalidate();

        CommonResp commonResp = new CommonResp();
        return commonResp;
    }



}
