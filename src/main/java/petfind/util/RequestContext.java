package petfind.util;

import java.io.Serializable;

/**
 * @ClassName RequestContext
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/20 下午8:35
 * @Version 1.0
 **/
public class RequestContext implements Serializable {
    private static ThreadLocal<String> remoteAddr = new ThreadLocal<>();

    public static String getRemoteAddr() {
        return remoteAddr.get();
    }

    public static void setRemoteAddr(String remoteAddr) {
        RequestContext.remoteAddr.set(remoteAddr);
    }
}
