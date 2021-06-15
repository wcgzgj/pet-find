package petfind.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;
import petfind.exception.BusinessException;
import petfind.exception.BusinessExceptionCode;
import petfind.pojo.User;
import petfind.req.UserLoginReq;
import petfind.resp.CommonResp;
import petfind.resp.UserLoginResp;
import petfind.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

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

    @PostMapping("login")
    public CommonResp login(@Valid @RequestBody UserLoginReq req, HttpServletRequest request) {
        HttpSession session = request.getSession();

        UserLoginResp login = userService.login(req);
        if (login==null) {
            throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
        }
        session.setAttribute("user",login);

        CommonResp commonResp = new CommonResp();
        commonResp.setContent(login);
        return commonResp;
    }




}
