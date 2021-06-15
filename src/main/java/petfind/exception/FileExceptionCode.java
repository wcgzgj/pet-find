package petfind.exception;

public enum FileExceptionCode {
    FILE_TYPE_ERROR("文件后缀错误"),
    FILE_SIZE_ERROR("文件大小错误"),
    FILE_INVALID("文件不合法"),
    FILE_READ_ERROR("文件读取错误"),
    FILE_WRITE_ERROR("文件写出操作");


    private String desc;

    FileExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
