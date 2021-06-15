package petfind.service;

import com.sun.tools.corba.se.idl.StringGen;
import org.springframework.web.multipart.MultipartFile;
import petfind.req.PicFindInfoSaveReq;
import petfind.resp.PicUploadResp;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName PicService
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/7 上午9:54
 * @Version 1.0
 **/
public interface PicService {

    /**
     * 存储图片路径
     * @param path
     * @return
     */
    int save(String path);

    /**
     * 获取所有图片的路径
     * @return
     */
    List<String> getAll();


    /**
     * 文件上传
     * @param file
     * @param req
     * @return
     */
    PicUploadResp upload(MultipartFile file, HttpServletRequest req);


    /**
     * 更新图片发现的地址
     * @param req
     */
    void uploadFindInfo(PicFindInfoSaveReq req);
}
