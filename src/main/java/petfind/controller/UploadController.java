package petfind.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import petfind.resp.CommonResp;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UploadController
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/5/19 下午3:12
 * @Version 1.0
 **/
@RestController
public class UploadController {

    private static final Logger LOG= LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/upload")
    public CommonResp upload(MultipartFile file, HttpServletRequest req) {
        /**
         * 获取tomcat容器中的路径
         */
        String path = req.getSession().getServletContext().getRealPath("load");
        LOG.info("获取的tomcat路径为:"+path);

        CommonResp resp = new CommonResp();
        return resp;
    }

}
