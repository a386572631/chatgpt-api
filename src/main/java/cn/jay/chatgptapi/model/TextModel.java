package cn.jay.chatgptapi.model;

import java.util.List;

/**
 * @Author: Jay<jin0201 @ foxmail.com>.
 * @Date: 2023/6/11-15:18
 * @Description: 发送文本聊天模型
 */
public class TextModel {
    private String model;
    private List<Message> messages;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
