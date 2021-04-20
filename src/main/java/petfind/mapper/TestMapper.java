package petfind.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import petfind.pojo.Test;

import java.util.List;

/**
 * @ClassName TestMapper
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/20 下午7:42
 * @Version 1.0
 **/
@Repository
@Mapper
public interface TestMapper {
    List<Test> getList();
}
