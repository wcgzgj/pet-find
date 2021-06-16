package petfind.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import petfind.pojo.User;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName PicQueryResp
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/15 下午8:07
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PicQueryResp {

    private Long id;

    private String path;

    private String address;

    private Long userid;

    /**
     * 找到该宠物的志愿者的信息
     */
    private User user;

}
