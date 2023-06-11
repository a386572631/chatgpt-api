package cn.jay.chatgptapi.constants;

import java.util.Objects;
import java.util.stream.Stream;

public enum RoleType {
    SYS("system", "系统"),
    USER("user", "用户"),
    ASSISTANT("assistant", "助理");
    private String type;
    private String description;

    RoleType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public static RoleType of(String type) {
        Objects.requireNonNull(type);
        return Stream.of(values()).filter(item -> Objects.equals(item.getType(), type))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("chatgpt.role配置有误"));
    }
}
