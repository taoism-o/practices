package com.linewell.desk.quest.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author kc
 * @title
 * @description The class DataConfigurationTest is for
 * @date Create in 18:30 2019/12/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataConfigurationTest {
    @Autowired
    private DataConfiguration dataConfiguration;

    @Test
    public void testParameters() {
        System.out.println(dataConfiguration.getDataPath());
    }
}
