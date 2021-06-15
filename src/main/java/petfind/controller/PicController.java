package petfind.controller;

import org.apache.ibatis.annotations.Update;
import org.aspectj.weaver.NewFieldTypeMunger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import petfind.req.PicFindInfoSaveReq;
import petfind.resp.CommonResp;
import petfind.resp.PicUploadResp;
import petfind.service.PicService;
import petfind.util.SnowFlake;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
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

    private static final Logger LOG= LoggerFactory.getLogger(PicController.class);

    @Resource
    private PicService picService;

    @Resource
    private SnowFlake snowFlake;

    @RequestMapping("/list")
    public CommonResp list() {
        List<String> list = picService.getAll();
        CommonResp commonResp = new CommonResp();
        commonResp.setContent(list);
        return commonResp;
    }


    /**
     * 图片上传接口
     * 将图片上传后，会将改名后的图片名称，以及其主键返回给前端
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadPic")
    public CommonResp upload(@RequestParam MultipartFile file,HttpServletRequest request) throws IOException {
        PicUploadResp upload = picService.upload(file, request);
        CommonResp commonResp = new CommonResp();
        commonResp.setContent(upload);
        return commonResp;
    }


    /**
     * 更新图片的发现位置接口
     * @param req
     * @return
     */
    @PostMapping("/uploadFindInfo")
    public CommonResp uploadFindInfo(@RequestBody @Valid PicFindInfoSaveReq req) {
        picService.uploadFindInfo(req);
        CommonResp commonResp = new CommonResp();

        return commonResp;
    }

}
