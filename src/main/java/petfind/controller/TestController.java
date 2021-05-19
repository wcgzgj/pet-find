package petfind.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petfind.pojo.Test;
import petfind.service.TestService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/20 下午7:44
 * @Version 1.0
 **/
@RestController
@RequestMapping("/tqest")
public class TestController {

    private static final Logger LOG= LoggerFactory.getLogger(TestController.class);

    @Resource
    private TestService testService;

    @RequestMapping("/list")
    public List<Test> list() {
        LOG.info("进入 TestController");
        return testService.getList();
    }
}
