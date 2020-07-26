import com.yzm.MockMapper;
import com.yzm.MockModel;
import com.yzm.MockServiceImpl;
import com.yzm.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.MockUtil;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName MockExample
 * @Description: TODO
 * @Author zhiMing.yue
 * @Date 2020/06/25 23:36
 **/
@RunWith(PowerMockRunner.class) // 告诉JUnit使用PowerMockRunner进行测试
@PrepareForTest({MockUtil.class}) // 所有需要测试的类列在此处，适用于模拟final类或有final, private, static, native方法的类
@PowerMockIgnore("javax.management.*") //为了解决使用powermock后，提示classloader错误
public class MockExample {
    // 将@Mock注解的示例注入进来
    @InjectMocks
    private MockServiceImpl mockService;
    @Mock
    private MockMapper mockMapper;

    /**
     * mock普通方法
     */
    @Test
    public void testSelectAppAdvertisementList() {
        MockModel model = new MockModel();
        PowerMockito.when(mockMapper.count(model)).thenReturn(2);
        MockMapper mock = PowerMockito.mock(MockMapper.class);
        mock.count2(model);
        mockService.count(model);
        mockService.count2(model);
        /*PowerMockito.when(mockMapper.count2(model)).thenReturn(Mockito.any());
        Assert.assertEquals(2, mockService.count(model));*/
        //PowerMockito.doNothing().when(mockMapper.count2(model));



    }

    @Test
    public void testSelectAppAdvertisementList2() {
        MockModel model = new MockModel();
        mockService.count(model);
    }
}