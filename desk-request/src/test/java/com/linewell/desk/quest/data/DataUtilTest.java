package com.linewell.desk.quest.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author kc
 * @title
 * @description The class DataUtilTest is for
 * @date Create in 18:07 2019/12/4
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataUtilTest {

    @Test
    public void testGetAreas() throws IOException {
        HashMap<String, String> areaMap = DataUtils.getAreaMap();
        System.out.println(areaMap.get("1300002"));
    }

    @Test
    public void testCheckFileExists() {
        System.out.println(DataUtils.checkFileExists());
    }
}
