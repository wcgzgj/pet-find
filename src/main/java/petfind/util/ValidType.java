package petfind.util;

/**
 * 校验规则
 */
public enum ValidType {

    PIC("图片");

    private String desc;

    ValidType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
