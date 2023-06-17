package cn.jay.chatgptapi.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import cn.jay.chatgptapi.config.ChatGPTProperties;
import cn.jay.chatgptapi.config.ImageProperties;
import cn.jay.chatgptapi.exception.ChatGptException;
import cn.jay.chatgptapi.model.image.ImageModel;
import cn.jay.chatgptapi.model.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: Jay<jin0201 @ foxmail.com>.
 * @Date: 2023/6/11-21:33
 * @Description: 生成图片
 */
@Service(value = "image")
public class ImageChat implements IChat {
    private final String URL_PATH = "/v1/images/generations";

    @Autowired
    ChatGPTProperties chatGPTProperties;

    @Override
    public List<String> chat(String content) throws ChatGptException {
        String url = chatGPTProperties.getProxyUrl();
        String apiKey = chatGPTProperties.getApiKey();
        ImageModel imageModel = new ImageModel();
        imageModel.setPrompt(content);
        imageModel.setN(chatGPTProperties.getImage().getNum());
        imageModel.setSize(chatGPTProperties.getImage().getSize());

        String bodyStr = JSONUtil.toJsonStr(imageModel);
        log.info("request: " + bodyStr);
        HttpResponse httpResponse = HttpRequest
                .post(url + URL_PATH)
                .header("Authorization", "Bearer " + apiKey)
                .body(bodyStr)
                .execute();
        ImageResponse imageResponse = JSONUtil.toBean(httpResponse.body(), ImageResponse.class);
        log.info("response: " + imageResponse.toString());
        if (Objects.isNull(imageResponse.getCreated())) {
            throw new ChatGptException("配置异常");
        }
        return imageResponse.getData().stream().map(ImageResponse.Data::getUrl).collect(Collectors.toList());
    }
}
