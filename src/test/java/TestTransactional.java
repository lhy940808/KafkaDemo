import com.lhy.boot.MainApplication;
import com.lhy.boot.service.ServiceA;
import com.lhy.boot.service.ServiceB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * 进行事务的测试
 * @author liuhaiyan
 * @date 2019-11-12 14:22
 */
@SpringBootTest(classes=MainApplication.class)
@RunWith(SpringRunner.class)
public class TestTransactional {
    @Resource
    private ServiceA serviceA;
    @Resource
    private ServiceB serviceB;


    @Test
    /**
     * @Description :场景一，a类的方法中使用事务注解，b类的方法不使用事务
     * @params []
     * @return void
     * @author liuhaiyan
     * @date 2019-11-12 14:34
     */
    public void test1() {
        serviceA.methodA();
        serviceA.methodA1();

    }

}
