package com.yzm;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName MockServiceImpl
 * @Description: TODO
 * @Author zhiMing.yue
 * @Date 2020/06/25 23:32
 **/
public class MockServiceImpl {
    @Autowired
    private MockMapper mockMapper;

    public int count(MockModel model) {
        return mockMapper.count(model);
    }

    public int count2(MockModel model) {
         mockMapper.count2(model);
        System.out.println();
        return 1;
    }
}
