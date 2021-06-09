package petfind.service.impl;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;
import petfind.mapper.PicMapper;
import petfind.pojo.Pic;
import petfind.service.PicService;
import petfind.util.CopyUtil;
import petfind.util.SnowFlake;

import javax.annotation.Resource;
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
    private SnowFlake snowFlake;

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
     *
     * @return
     */
    @Override
    public List<String> getAll() {
        List<Pic> pics = picMapper.selectByExample(null);
        List<String> paths = new ArrayList<>();
        for (Pic pic : pics) {
            paths.add(pic.getPath());
        }
        return paths;
    }
}
