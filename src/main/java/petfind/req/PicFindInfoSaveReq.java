package petfind.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PicFindInfoSaveReq
 * @Description 图片上传信息请求
 * 即图片已经被上传至服务器了，我们要将图片对应的发现地址，一并保存至数据库
 * @Author FARO_Z
 * @Date 2021/6/15 下午5:50
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PicFindInfoSaveReq {
    private String newPicId;
    private String address;
}
