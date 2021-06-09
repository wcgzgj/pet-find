package petfind.exception;

/**
 * @ClassName FileException
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/7 上午8:51
 * @Version 1.0
 **/
public class FileException extends RuntimeException {

    private FileExceptionCode code;

    public FileException(FileExceptionCode code) {
        super(code.getDesc());
        this.code = code;
    }

    public FileExceptionCode getCode() {
        return code;
    }

    public void setCode(FileExceptionCode code) {
        this.code = code;
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
