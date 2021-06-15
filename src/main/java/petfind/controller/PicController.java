package petfind.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import petfind.resp.CommonResp;
import petfind.service.PicService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/list")
    public CommonResp list() {
        List<String> list = picService.getAll();
        CommonResp commonResp = new CommonResp();
        commonResp.setContent(list);
        return commonResp;
    }


    @PostMapping("/upload")
    public CommonResp upload(@RequestParam("file") MultipartFile file) {

        LOG.info("待上传的文件信息为:",file);
        LOG.info("待上传的文件名称为:",file.getOriginalFilename());

        /**
         * const status = info.file.status;
         *    if (status !== 'uploading') {
         *        console.log(info.file, info.fileList);
         *    }
         *
         *    if (status === 'done') {
         *        message.success(`${info.file.name} file uploaded successfully.`);
         *    } else if (status === 'error') {
         *        message.error(`${info.file.name} file upload failed.`);
         *    }
         */

        CommonResp commonResp = new CommonResp();
        // String filePath = fileService.upload(file, req);
        // int res = picService.save(filePath);
        // if (res<=0) {
        //     commonResp.setSuccess(false);
        //     commonResp.setMessage("图片存储失败");
        // }
        return commonResp;
    }

}
