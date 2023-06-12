package cn.jay.chatgptapi.utils;

import cn.jay.chatgptapi.exception.ChatGptException;

import java.util.List;
import java.util.logging.Logger;

public interface IChat {
    Logger log = Logger.getLogger(String.valueOf(IChat.class));

    /**
     * 聊天方法
     * @param content 需要发送给ChatGPT的话
     * @return
     * @throws ChatGptException
     */
    List<String> chat(String content) throws ChatGptException;
}
