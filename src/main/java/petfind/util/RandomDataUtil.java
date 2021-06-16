package petfind.util;

import java.util.Random;

/**
 * @ClassName RandomDataUtil
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/16 下午5:45
 * @Version 1.0
 **/
public class RandomDataUtil {

    private static Random r=new Random();

    /**
     * 生成随机6位验证码
     * @return
     */
    public static String randomCode() {
        return String.valueOf(r.nextInt(899999)+100000);
    }
}
