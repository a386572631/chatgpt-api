package cn.jay.chatgptapi.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import cn.jay.chatgptapi.constants.RoleType;
import cn.jay.chatgptapi.exception.ChatGptException;
import cn.jay.chatgptapi.model.Message;
import cn.jay.chatgptapi.model.TextModel;
import cn.jay.chatgptapi.model.TextResponse;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @Author: Jay<jin0201 @ foxmail.com>.
 * @Date: 2023/6/11-14:36
 * @Description: 文本聊天
 */
@Component
@ConfigurationProperties(prefix = "chatgpt")
public class TextChat {
    private static Logger log = Logger.getLogger(String.valueOf(TextChat.class));

    /**
     * ChatGPT代理URL，默认：api.openai.com
     */
    private String proxyUrl = "api.openai.com";
    /**
     * https://platform.openai.com/注册的APIKey
     */
    private String apiKey;
    /**
     * One of system, user, or assistant.
     */
    private String role = RoleType.USER.getType();

    public void setProxyUrl(String url) {
        this.proxyUrl = url;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setRole(String role) {
        this.role = RoleType.of(role).getType();
    }

    public String getProxyUrl() {
        return this.proxyUrl;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getRole() {
        return role;
    }

    public String chat(String content) throws ChatGptException {
        String url = this.getProxyUrl();
        String key = this.getApiKey();
        TextModel textModel = new TextModel();
        textModel.setModel("gpt-3.5-turbo");
        Message message = new Message();
        message.setRole(this.getRole());
        message.setContent(content);

        textModel.setMessages(Arrays.asList(message));
        String bodyStr = JSONUtil.toJsonStr(textModel);
        log.info("request: " + bodyStr);
        HttpResponse httpResponse = HttpRequest
                .post(url + "/v1/chat/completions")
                .header("Authorization", "Bearer " + key)
                .body(bodyStr)
                .execute();
        TextResponse textResponse = JSONUtil.toBean(httpResponse.body(), TextResponse.class);
        log.info("response: " + textResponse.toString());
        if (Objects.isNull(textResponse.getId())) {
            throw new ChatGptException("配置异常");
        }
        return textResponse.getChoices().size() == 0 ? "" : textResponse.getChoices().get(0).getMessage().getContent();
    }
}
