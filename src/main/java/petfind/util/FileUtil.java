package petfind.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * @ClassName FileUtil
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/6/7 上午8:58
 * @Version 1.0
 **/
public class FileUtil {

    private static final Logger LOG= LoggerFactory.getLogger(FileUtil.class);

    private static Set<String> picHzSet = new HashSet<>();
    private static Properties pp = new Properties();
    static {
        picHzSet.add(".jpg");
        picHzSet.add(".jpeg");
        picHzSet.add("png");


        try {
            InputStream is = FileUtil.class.getClassLoader().getResourceAsStream("path.properties");
            pp.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /**
     * 判断文件后缀是否合法
     * @param hz
     * @return
     */
    public static boolean isHzValid(String hz,ValidType type) {
        if (StringUtil.isEmpty(hz)) {
            return false;
        }
        switch (type) {
            case PIC:
                return isPicHzValid(hz);
            default:
                return false;
        }
    }


    /**
     * 检查图片后缀是否合法
     * @param hz
     * @return
     */
    public static boolean isPicHzValid(String hz) {
        if (picHzSet.contains(hz)) {
            return true;
        }
        return false;
    }


    /**
     * 获取配置文件中的信息
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return pp.getProperty(key);
    }

    /**
     * 将某个文件，复制到另一个位置
     * @param path
     * @return
     */
    public boolean writeFile(String path,File file) {
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            FileOutputStream fos = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 文件读取操作
     * @param path
     * @return
     */
    public File readFile(String path) {
        return null;
    }



}
