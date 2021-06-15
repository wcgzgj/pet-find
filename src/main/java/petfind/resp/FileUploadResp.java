package petfind.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName FileUploadResp
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/14 下午10:47
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileUploadResp {
    /**
     * {
     *     uid: '-1',
     *     name: 'xxx.png',
     *     status: 'done',
     *     url: 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png',
     *     thumbUrl: 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png',
     * },
     */
    private String uid;
    private String name;
    private String status;
    private String url;
    private String thumbUrl;

}
