package petfind;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import petfind.config.PetFindApplication;
import petfind.util.FileUtil;

@SpringBootTest(classes = PetFindApplication.class)
class PetFindApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void getPPTest() {
        String property = FileUtil.getProperty("path.inputCache");
        System.out.println(property);
    }

}
