package petfind.service.impl;

import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.AbstractFutureOrPresentInstantBasedValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import petfind.exception.BusinessException;
import petfind.exception.BusinessExceptionCode;
import petfind.mapper.UserMapper;
import petfind.pojo.User;
import petfind.pojo.UserExample;
import petfind.req.UserLoginReq;
import petfind.resp.UserLoginResp;
import petfind.service.UserService;
import petfind.util.CopyUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/9 下午5:20
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    /**
     * 根据用户名，查询用户信息
     *
     * @param name
     * @return
     */
    @Override
    public User selectByLoginName(String name) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLoginnameLike(name);

        List<User> users = userMapper.selectByExample(userExample);
        if (users==null || users.size()<=0) {
            return null;
        }
        return users.get(0);
    }

    /**
     * 用户登录服务层接口
     *
     * @param req
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor = Exception.class)
    @Override
    public UserLoginResp login(UserLoginReq req) {
        /**
         * 从数据库中查询用户信息
         */
        User user = selectByLoginName(req.getLoginname());

        /**
         * 判断登录
         */
        if (user==null) {
            return null;
        }

        if (!Objects.equals(user.getPassword(),req.getPassword())) {
            return null;
        }
        UserLoginResp copy = CopyUtil.copy(user, UserLoginResp.class);

        /**
         * 更新登录时间
         */
        user.setLogintime(new Date());
        userMapper.updateByPrimaryKey(user);

        return copy;
    }
}
