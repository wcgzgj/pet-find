package petfind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petfind.pojo.Demo;
import petfind.service.DemoService;

import java.util.List;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/20 下午8:31
 * @Version 1.0
 **/
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/demo/list")
    public List<Demo> list() {
        return demoService.getList();
    }
}
