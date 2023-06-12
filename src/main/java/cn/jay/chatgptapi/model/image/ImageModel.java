package cn.jay.chatgptapi.model.image;

/**
 * @Author: Jay<jin0201 @ foxmail.com>.
 * @Date: 2023/6/11-21:44
 * @Description:
 */
public class ImageModel {
    private String prompt;
    private Integer n;
    private String size;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ImageModel{" +
                "prompt='" + prompt + '\'' +
                ", n=" + n +
                ", size='" + size + '\'' +
                '}';
    }
}
