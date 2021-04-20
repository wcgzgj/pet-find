package petfind.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import petfind.pojo.Pic;
import petfind.pojo.PicExample;

public interface PicMapper {
    long countByExample(PicExample example);

    int deleteByExample(PicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Pic record);

    int insertSelective(Pic record);

    List<Pic> selectByExample(PicExample example);

    Pic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Pic record, @Param("example") PicExample example);

    int updateByExample(@Param("record") Pic record, @Param("example") PicExample example);

    int updateByPrimaryKeySelective(Pic record);

    int updateByPrimaryKey(Pic record);
}