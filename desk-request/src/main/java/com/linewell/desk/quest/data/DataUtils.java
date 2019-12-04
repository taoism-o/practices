package com.linewell.desk.quest.data;

import com.linewell.desk.quest.configuration.DataConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author kc
 * @title
 * @description The class DataUtils is for
 * @date Create in 17:49 2019/12/4
 */
@Component
public class DataUtils {

    private static DataConfiguration dataConfiguration;

    @Autowired
    private void setDataConfiguration(DataConfiguration df) {
        dataConfiguration = df;
    }

    /**
     * @Author k5068
     * @Date 2019/12/4 22:51
     * @Description This is description of method taking area infos in map
     * @Param []
     * @Return java.util.HashMap<java.lang.String,java.lang.String>
     * @Since
     */
    public static HashMap<String, String> getAreaMap() throws IOException {
        HashMap<String, String> areaMap = new HashMap<String, String>();

        File file = new File(dataConfiguration.getDataPath());

        if (file.exists()) {
            if (file.isFile()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String s = null;
                while ((s = br.readLine()) != null) {
                    String[] areaInfos = s.trim().split("\\s",2);
                    areaMap.put(areaInfos[0], areaInfos[1]);
                }

                br.close();
            }
        }

        return areaMap;
    }
}
