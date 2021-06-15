package petfind.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName UserLoginResp
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/15 下午2:45
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginResp {
    private Long id;

    private String loginname;

    private String realname;

    private String email;

    private String address;
}
