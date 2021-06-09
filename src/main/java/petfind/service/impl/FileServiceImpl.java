package petfind.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import petfind.exception.FileException;
import petfind.exception.FileExceptionCode;
import petfind.service.FileService;
import petfind.util.FileUtil;
import petfind.util.SnowFlake;
import petfind.util.ValidType;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName FileServiceImpl
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/7 上午8:44
 * @Version 1.0
 **/
@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOG= LoggerFactory.getLogger(FileServiceImpl.class);

    @Resource
    private SnowFlake snowFlake;

    /**
     * 文件上传
     * 上传后，返回文件的全路径
     *
     * @param file
     * @param req
     * @return 文件存放的全路径
     */
    @Override
    public String upload(MultipartFile file, HttpServletRequest req) {

        /**
         * 获取tomcat容器中的路径
         */
        String path = req.getSession().getServletContext().getRealPath("/upload");
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

        return newPath;
    }
}
