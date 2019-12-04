package com.linewell.desk.quest.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author kc
 * @title
 * @description The class DataConfiguration is for
 * @date Create in 18:24 2019/12/4
 */
@Configuration
@Data
public class DataConfiguration {

    @Value("${quest.area.data.path}")
    private String dataPath;
}

