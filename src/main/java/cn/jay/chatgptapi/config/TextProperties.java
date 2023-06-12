package cn.jay.chatgptapi.config;

import cn.jay.chatgptapi.constants.RoleType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jay<jin0201 @ foxmail.com>.
 * @Date: 2023/6/11-21:01
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "text")
public class TextProperties extends ChatGPTProperties {

    /**
     * One of system, user, or assistant.
     */
    private static String role = RoleType.USER.getType();

    public void setRole(String role) {
        this.role = RoleType.of(role).getType();
    }

    public static String getRole() {
        return TextProperties.role;
    }
}
