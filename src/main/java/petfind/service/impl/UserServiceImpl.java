package petfind.service.impl;

import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.AbstractFutureOrPresentInstantBasedValidator;
import petfind.mapper.UserMapper;
import petfind.service.UserService;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/9 下午5:20
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;





}
