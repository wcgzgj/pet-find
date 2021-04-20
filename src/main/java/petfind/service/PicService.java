package petfind.service;

import org.springframework.stereotype.Service;
import petfind.mapper.PicMapper;
import petfind.pojo.Pic;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PicService
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/20 下午8:32
 * @Version 1.0
 **/
@Service
public class PicService {

    @Resource
    private PicMapper picMapper;

    public List<Pic> getList() {
        List<Pic> list = picMapper.selectByExample(null);
        return list;
    }
}
