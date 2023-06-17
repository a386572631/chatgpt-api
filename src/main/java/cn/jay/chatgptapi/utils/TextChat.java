package cn.jay.chatgptapi.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import cn.jay.chatgptapi.config.ChatGPTProperties;
import cn.jay.chatgptapi.exception.ChatGptException;
import cn.jay.chatgptapi.model.text.Message;
import cn.jay.chatgptapi.model.text.TextModel;
import cn.jay.chatgptapi.model.text.TextResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: Jay<jin0201 @ foxmail.com>.
 * @Date: 2023/6/11-14:36
 * @Description: 文本聊天
 */
@Service(value = "text")
public class TextChat implements IChat {
    private final String URL_PATH = "/v1/chat/completions";
    @Autowired
    ChatGPTProperties chatGPTProperties;

    public List<String> chat(String content) throws ChatGptException {
        String url = chatGPTProperties.getProxyUrl();
        String key = chatGPTProperties.getApiKey();
        TextModel textModel = new TextModel();
        textModel.setModel("gpt-3.5-turbo");
        Message message = new Message();
        message.setRole(chatGPTProperties.getText().getRole());
        message.setContent(content);

        textModel.setMessages(Arrays.asList(message));
        String bodyStr = JSONUtil.toJsonStr(textModel);
        log.info("request: " + bodyStr);
        HttpResponse httpResponse = HttpRequest
                .post(url + URL_PATH)
                .header("Authorization", "Bearer " + key)
                .body(bodyStr)
                .execute();
        TextResponse textResponse = JSONUtil.toBean(httpResponse.body(), TextResponse.class);
        log.info("response: " + textResponse.toString());
        if (Objects.isNull(textResponse.getId())) {
            throw new ChatGptException("配置异常");
        }
        return textResponse.getChoices()
                .stream().map(TextResponse.Choices::getMessage).collect(Collectors.toList())
                .stream().map(Message::getContent).collect(Collectors.toList());
    }
}
