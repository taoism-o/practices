package com.linewell.desk.quest.area;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Random;

import com.carrotsearch.sizeof.RamUsageEstimator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {
	
	private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AreaServiceTest.class);
	
    @Autowired
    private AreaService areaService;

    @Test
    public void getArea() throws IOException {
        assertNull(areaService.getArea("12900012333"));

        assertEquals(1300002, areaService.getArea("13000020001").getPrefix());
        assertEquals(393, areaService.getArea("13000020001").getCode());
        assertEquals("测试地区.393", areaService.getArea("13000020001").getName());

        assertEquals(1969742, areaService.getArea("19697420001").getPrefix());
        assertEquals(2, areaService.getArea("19697420001").getCode());
        assertEquals("广东.深圳", areaService.getArea("19697420001").getName());
    }

    @Test
    public void benchmark() throws IOException {
        Random r = new Random();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String phone = "13" + String.format("%09d", r.nextInt(999999999));
            areaService.getArea(phone);
        }
        long time = System.currentTimeMillis() - t1;
        log.info("time cost:{},  tps:{}", time, 10000f / time * 1000);
    }

    @Test
    public void memoryUsage() {
       long objectSize = RamUsageEstimator.sizeOf(areaService);
       log.info("memory:{} KB", objectSize);
       assertTrue(objectSize  < 10 * 1024 * 1024L);
    }

}