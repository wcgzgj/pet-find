package petfind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petfind.pojo.Pic;
import petfind.service.PicService;

import java.util.List;

/**
 * @ClassName PicController
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/20 下午8:31
 * @Version 1.0
 **/
@RestController
public class PicController {

    @Autowired
    private PicService picService;

    @RequestMapping("/pic/list")
    public List<Pic> list() {
        return picService.getList();
    }
}
