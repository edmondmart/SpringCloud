// P27-04-Nacos配置管理-配置热更新
// P28-05-Nacos配置管理-多环境配置共享

package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {

    private String dateformat;
    private String envSharedValue;

}
