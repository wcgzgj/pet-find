package petfind.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @ClassName UserSaveReq
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/16 下午5:26
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSaveReq {

    private Long id;

    @NotEmpty(message = "请输入登录名")
    private String loginname;

    @NotEmpty(message = "请输入真实姓名")
    private String realname;

    @NotEmpty(message = "请输入密码")
    private String password;

    @NotEmpty(message = "请输入邮箱")
    private String email;
}
