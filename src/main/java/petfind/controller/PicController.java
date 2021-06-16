package petfind.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import petfind.pojo.User;
import petfind.req.PicFindInfoSaveReq;
import petfind.resp.CommonResp;
import petfind.resp.PicQueryResp;
import petfind.resp.PicUploadResp;
import petfind.service.PicService;
import petfind.util.SnowFlake;

import javax.annotation.Resource;
import javax.validation.Valid;
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

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("/list")
    public CommonResp list() {
        List<PicQueryResp> list = picService.getAll();
        CommonResp commonResp = new CommonResp();
        commonResp.setContent(list);
        return commonResp;
    }


    /**
     * 图片上传接口
     * 将图片上传后，会将改名后的图片名称，以及其主键返回给前端
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadPic")
    public CommonResp upload(@RequestParam MultipartFile file) {
        PicUploadResp upload = picService.upload(file);
        CommonResp commonResp = new CommonResp();
        commonResp.setContent(upload);
        return commonResp;
    }


    /**
     * 上传找寻图片
     * 放到缓存数据区，再调用 python 接口，查找图片
     * @param file
     * @return
     */
    @PostMapping("/uploadFindPic")
    public CommonResp uploadFindPic(@RequestParam MultipartFile file) {

        /**
         * ！！！伪造返回数据
         * 后面需要删除
         */
        List<PicQueryResp> all = picService.getAll();

        /**
         * 将图片存储到图片暂存区
         */
        //------

        /**
         * 调用 service 层代码
         * 调用 python 脚本，获取到对应的图片的信息
         */
        //-------


        CommonResp commonResp = new CommonResp();
        commonResp.setContent(all);

        return commonResp;
    }


    /**
     * 更新图片的发现位置接口
     * @param req
     * @return
     */
    @PostMapping("/uploadFindInfo")
    public CommonResp uploadFindInfo(@RequestBody @Valid PicFindInfoSaveReq req) {
        CommonResp commonResp = new CommonResp();

        String userId = req.getUserId();
        LOG.info("传来的用户 id为:{}",userId);

        Object o = redisTemplate.opsForValue().get(userId);
        if (o==null) {
            /**
             * 在用户未登录的情况下，禁止用户执行图片上传操作
             */
            commonResp.setSuccess(false);
            commonResp.setContent("错误，当前用户未登录");
            return commonResp;
        }

        picService.uploadFindInfo(req);

        return commonResp;
    }

}
