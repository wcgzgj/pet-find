package petfind.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName UserLoginReq
 * @Description 用户登录请求
 * @Author FARO_Z
 * @Date 2021/6/15 下午2:36
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginReq {

    @NotEmpty
    private String loginname;

    @NotEmpty
    private String password;

}
