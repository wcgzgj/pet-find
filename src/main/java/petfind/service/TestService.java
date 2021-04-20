package petfind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petfind.mapper.TestMapper;
import petfind.pojo.Test;

import java.util.List;

/**
 * @ClassName TestService
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/20 下午7:44
 * @Version 1.0
 **/
@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public List<Test> getList() {
        return testMapper.getList();
    }
}
