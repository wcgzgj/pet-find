package petfind.service;

import org.springframework.stereotype.Service;
import petfind.mapper.DemoMapper;
import petfind.pojo.Demo;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DemoService
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/20 下午8:32
 * @Version 1.0
 **/
@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

    public List<Demo> getList() {
        List<Demo> list = demoMapper.selectByExample(null);
        return list;
    }
}
