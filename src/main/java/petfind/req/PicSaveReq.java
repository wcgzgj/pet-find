package petfind.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PicSaveReq
 * @Description 志愿者上传图片信息的请求
 * @Author FARO_Z
 * @Date 2021/6/15 下午5:12
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PicSaveReq {

    private String address;
    private String userId;
    private String picId;

}
