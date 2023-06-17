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
    private String proxyUrl = "api.openai.com";
    /**
     * https://platform.openai.com/注册的APIKey
     */
    private String apiKey;
    /**
     * 文本输入对话
     */
    private TextProperties text;
    /**
     * 文本生成图片
     */
    private ImageProperties image;

    public void setProxyUrl(String url) {
        this.proxyUrl = url;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getProxyUrl() {
        return this.proxyUrl;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public TextProperties getText() {
        return text;
    }

    public void setText(TextProperties text) {
        this.text = text;
    }

    public ImageProperties getImage() {
        return image;
    }

    public void setImage(ImageProperties image) {
        this.image = image;
    }
}
