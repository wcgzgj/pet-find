package petfind.service;

import petfind.mapper.UserMapper;
import petfind.pojo.User;
import petfind.req.UserLoginReq;
import petfind.resp.UserLoginResp;

import javax.annotation.Resource;

public interface UserService {

    /**
     * 根据用户名，查询用户信息
     * @param name
     * @return
     */
    User selectByLoginName(String name);


    /**
     * 用户登录服务层接口
     * @param req
     * @return
     */
    UserLoginResp login(UserLoginReq req);




}
