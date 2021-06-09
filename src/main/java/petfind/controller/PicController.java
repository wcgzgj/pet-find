package petfind.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petfind.resp.CommonResp;
import petfind.service.PicService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PicController
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/7 上午10:06
 * @Version 1.0
 **/
@RestController
@RequestMapping("/pic")
public class PicController {

    @Resource
    private PicService picService;

    @RequestMapping("/list")
    public CommonResp list() {
        List<String> list = picService.getAll();
        CommonResp commonResp = new CommonResp();
        commonResp.setContent(list);
        return commonResp;
    }

}
