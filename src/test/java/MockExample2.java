import com.yzm.MockUtil;
import com.yzm.RedisUtil;
import jdk.internal.dynalink.beans.StaticClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.function.Consumer;

/**
 * @ClassName MockExample2
 * @Description: TODO
 * @Author zhiMing.yue
 * @Date 2020/06/25 23:44
 **/

@RunWith(PowerMockRunner.class) // 告诉JUnit使用PowerMockRunner进行测试
@PrepareForTest({MockUtil.class,RedisUtil.class}) // 所有需要测试的类列在此处，适用于模拟final类或有final, private, static, native方法的类
@PowerMockIgnore("javax.management.*") //为了解决使用powermock后，提示classloader错误
public class MockExample2 {
    @Test
    public void testStaticMethod() {
        PowerMockito.mockStatic(MockUtil.class);
        PowerMockito.when(MockUtil.nextInt(10)).thenReturn(7);

        Assert.assertEquals(7, MockUtil.nextInt(10));

        PowerMockito.mockStatic(RedisUtil.class);
        PowerMockito.doNothing().when(RedisUtil.class);
        RedisUtil.redisLock(Mockito.any(String.class), Mockito.any());



//Consumer<Void> consumer
    }
}

