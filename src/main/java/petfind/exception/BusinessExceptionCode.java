package petfind.exception;

/**
 * @ClassName BusinessExceptionCode
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/20 下午8:40
 * @Version 1.0
 **/
public enum BusinessExceptionCode {
    USER_LOGIN_NAME_EXIST("登录名已存在"),
    LOGIN_USER_ERROR("用户名不存在或密码错误"),
    VOTE_REPEAT("您已点赞过"),
    ;

    private String desc;

    BusinessExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
