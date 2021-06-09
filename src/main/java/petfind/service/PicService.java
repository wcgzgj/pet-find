package petfind.service;

import com.sun.tools.corba.se.idl.StringGen;

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
}
