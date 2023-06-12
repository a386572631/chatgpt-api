package cn.jay.chatgptapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jay<jin0201 @ foxmail.com>.
 * @Date: 2023/6/11-21:23
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "chatgpt")
public class ChatGPTProperties {
    /**
     * ChatGPT代理URL，默认：api.openai.com
     */
    protected static String proxyUrl = "api.openai.com";
    /**
     * https://platform.openai.com/注册的APIKey
     */
    protected static String apiKey;

    public void setProxyUrl(String url) {
        this.proxyUrl = url;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public static String getProxyUrl() {
        return TextProperties.proxyUrl;
    }

    public static String getApiKey() {
        return TextProperties.apiKey;
    }
}
