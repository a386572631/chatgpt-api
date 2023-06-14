package cn.jay.chatgptapi.config;

import cn.jay.chatgptapi.constants.RoleType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Jay<jin0201 @ foxmail.com>.
 * @Date: 2023/6/11-21:01
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "chatgpt.text")
public class TextProperties {

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
