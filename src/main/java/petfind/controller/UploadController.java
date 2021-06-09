package petfind.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import petfind.resp.CommonResp;
import petfind.service.FileService;
import petfind.service.PicService;
import petfind.util.SnowFlake;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName UploadController
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/5/19 下午3:12
 * @Version 1.0
 **/
@RestController
@RequestMapping("/file")
public class UploadController {

    private static final Logger LOG= LoggerFactory.getLogger(UploadController.class);

    @Resource
    private SnowFlake snowFlake;

    @Resource
    private FileService fileService;

    @Resource
    private PicService picService;

    @PostMapping("/upload")
    public CommonResp upload(MultipartFile file, HttpServletRequest req) {
        CommonResp commonResp = new CommonResp();
        String filePath = fileService.upload(file, req);
        int res = picService.save(filePath);
        if (res<=0) {
            commonResp.setSuccess(false);
            commonResp.setMessage("图片存储失败");
        }
        return commonResp;
    }

}
