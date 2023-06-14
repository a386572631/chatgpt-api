package cn.jay.chatgptapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Jay<jin0201 @ foxmail.com>.
 * @Date: 2023/6/11-21:23
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "chatgpt")
public class ChatGPTProperties {
    /**
     * ChatGPT代理URL，默认：api.openai.com
     */
    private static String proxyUrl = "api.openai.com";
    /**
     * https://platform.openai.com/注册的APIKey
     */
    private static String apiKey;
    /**
     * 文本输入对话
     */
    private static TextProperties text;
    /**
     * 文本生成图片
     */
    private static ImageProperties image;

    public void setProxyUrl(String url) {
        this.proxyUrl = url;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public static String getProxyUrl() {
        return ChatGPTProperties.proxyUrl;
    }

    public static String getApiKey() {
        return ChatGPTProperties.apiKey;
    }

    public static TextProperties getText() {
        return text;
    }

    public static void setText(TextProperties text) {
        ChatGPTProperties.text = text;
    }

    public static ImageProperties getImage() {
        return image;
    }

    public static void setImage(ImageProperties image) {
        ChatGPTProperties.image = image;
    }
}
