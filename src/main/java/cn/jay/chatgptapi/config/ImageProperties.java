package cn.jay.chatgptapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Jay<jin0201 @ foxmail.com>.
 * @Date: 2023/6/11-21:11
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "chatgpt.image")
public class ImageProperties {
    /**
     * Must be between 1 and 10
     */
    private static Integer num;

    /**
     * one of 256x256, 512x512, or 1024x1024
     */
    private static String size = "1024x1024";

    public static Integer getNum() {
        return num;
    }

    public void setNum(Integer n) {
        this.num = n;
    }

    public static String getSize() {
        return ImageProperties.size;
    }

    public void setSize(String size) {
        ImageProperties.size = size;
    }
}
