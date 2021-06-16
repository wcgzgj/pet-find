package petfind;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import petfind.config.PetFindApplication;
import petfind.pojo.User;
import petfind.util.FileUtil;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = PetFindApplication.class)
class PetFindApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void redisTest() {
        User user = new User();
        user.setLoginname("jojo");
        user.setEmail("zhang@qq.com");
        redisTemplate.opsForValue().set("user", JSON.toJSON(user), 5,TimeUnit.SECONDS);
        System.out.println("redis 中获取的数据为："+redisTemplate.opsForValue().get("user"));

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("redis 超时后获取的数据为："+redisTemplate.opsForValue().get("user"));
    }

}
