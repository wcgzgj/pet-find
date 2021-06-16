package petfind.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import petfind.exception.FileException;
import petfind.exception.FileExceptionCode;
import petfind.mapper.PicMapper;
import petfind.mapper.UserMapper;
import petfind.pojo.Pic;
import petfind.pojo.User;
import petfind.req.PicFindInfoSaveReq;
import petfind.resp.PicQueryResp;
import petfind.resp.PicUploadResp;
import petfind.service.PicService;
import petfind.util.CopyUtil;
import petfind.util.FileUtil;
import petfind.util.SnowFlake;
import petfind.util.ValidType;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PicServiceImpl
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/7 上午9:55
 * @Version 1.0
 **/
@Service
public class PicServiceImpl implements PicService {

    @Resource
    private PicMapper picMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private SnowFlake snowFlake;

    private static final Logger LOG= LoggerFactory.getLogger(PicServiceImpl.class);

    /**
     * 存储图片路径
     *
     * @param path
     * @return
     */
    @Override
    public int save(String path) {
        Long id = snowFlake.nextId();
        Pic pic = new Pic();
        pic.setId(id);
        pic.setPath(path);
        int res = picMapper.insertSelective(pic);
        return res;
    }

    /**
     * 获取所有图片的路径
     * 因为涉及多表查询，所以要开启事务
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public List<PicQueryResp> getAll() {
        List<Pic> pics = picMapper.selectByExample(null);

        List<PicQueryResp> picQueryResps = CopyUtil.copyList(pics, PicQueryResp.class);
        for (PicQueryResp picQueryResp : picQueryResps) {
            User user = userMapper.selectByPrimaryKey(picQueryResp.getUserid());
            LOG.info("查找到的用户信息为:{}",user);
            picQueryResp.setUser(user);
        }
        return picQueryResps;
    }


    /**
     * 文件上传
     * 上传后，返回文件的全路径
     *
     * @param file
     * @return 文件存放的全路径
     */
    @Override
    public PicUploadResp upload(MultipartFile file) {
        String path = "/Users/faro_z/Pictures/cat_db";
        String originalFilename = file.getOriginalFilename();

        LOG.info("获取的文件名为:{}",originalFilename);
        /**
         * 获取文件后缀
         */
        String hz = originalFilename.substring(originalFilename.lastIndexOf("."));

        LOG.info("获取的文件后缀为:{}",hz);


        //判断图片后缀是否合法
        boolean valid = FileUtil.isHzValid(hz, ValidType.PIC);
        if (!valid) {
            throw new FileException(FileExceptionCode.FILE_TYPE_ERROR);
        }

        String newFileName = snowFlake.nextId().toString()+hz;
        StringBuilder sb = new StringBuilder();
        sb.append(path)
                .append("/")
                .append(newFileName);
        String newPath = sb.toString();
        try {
            file.transferTo(new File(newPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Long newPicId = snowFlake.nextId();
        Pic pic = new Pic();
        pic.setId(newPicId);
        LOG.info("待插入的图片主键为",pic.getId());
        pic.setPath(newFileName);
        picMapper.insertSelective(pic);


        /**
         * 需要将保存后的图片名称，和图片 id 返回出去
         */
        PicUploadResp picUploadResp = new PicUploadResp();
        picUploadResp.setNewPicName(newFileName);
        picUploadResp.setNewPicId(newPicId.toString());
        picUploadResp.setNewPicPath("http://127.0.0.1:9000/disPic/"+newFileName);

        return picUploadResp;
    }

    /**
     * 更新图片发现的地址
     *
     * @param req
     */
    @Override
    public void uploadFindInfo(PicFindInfoSaveReq req) {
        Pic pic = new Pic();
        pic.setAddress(req.getAddress());
        pic.setId(Long.parseLong(req.getNewPicId()));
        pic.setUserid(Long.parseLong(req.getUserId()));
        /**
         * 更新已经存在数据库中的图片的发现地址
         * 和上传该图片的用户的信息
         */
        picMapper.updateByPrimaryKeySelective(pic);
    }


}
