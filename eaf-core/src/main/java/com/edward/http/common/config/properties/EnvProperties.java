package com.edward.http.common.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangcheng
 * @date 2020/5/8 18:27
 */
@Data
@Component
@ConfigurationProperties("env")
public class EnvProperties {
    String evnIp;
    String gunsPort;
}
