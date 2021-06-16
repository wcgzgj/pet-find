package petfind.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import petfind.exception.BusinessException;
import petfind.exception.BusinessExceptionCode;
import petfind.pojo.User;
import petfind.req.UserLoginReq;
import petfind.resp.CommonResp;
import petfind.resp.UserLoginResp;
import petfind.service.UserService;
import petfind.util.CopyUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private RedisTemplate redisTemplate;

    private static final Logger LOG= LoggerFactory.getLogger(UserController.class);

    /**
     * 登录接口
     * @param req
     * @return
     */
    @PostMapping("login")
    public CommonResp login(@Valid @RequestBody UserLoginReq req) {

        UserLoginResp login = userService.login(req);
        if (login==null) {
            throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
        }
        User copy = CopyUtil.copy(login, User.class);

        /**
         * 保存用户的登录信息
         * 保存时间为一天
         */
        redisTemplate.opsForValue().set(copy.getId().toString(), JSON.toJSON(copy),3600*24, TimeUnit.SECONDS);

        CommonResp commonResp = new CommonResp();
        commonResp.setContent(login);
        return commonResp;
    }


    /**
     * 登出接口
     * 登出接口只需要使 session 失效就ok了
     * @return
     */
    @PostMapping("/logout/{id}")
    public CommonResp logout(@PathVariable("id")String id) {
        LOG.info("待删除的用户的id为：{}",id);

        /**
         * redis 中，清空用户登录信息
         */
        redisTemplate.delete(id);

        CommonResp commonResp = new CommonResp();
        return commonResp;
    }



}
