package petfind.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PicUploadResp
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/15 下午5:25
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PicUploadResp {

    private String newPicName;
    private String newPicId;
    private String newPicPath;

}
