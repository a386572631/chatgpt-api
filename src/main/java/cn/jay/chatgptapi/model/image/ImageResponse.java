package cn.jay.chatgptapi.model.image;

import java.util.List;

/**
 * @Author: Jay<jin0201 @ foxmail.com>.
 * @Date: 2023/6/11-21:49
 * @Description:
 */
public class ImageResponse {
    private Long created;
    private List<Data> data;

    public static class Data {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "url='" + url + '\'' +
                    '}';
        }
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ImageResponse{" +
                "created=" + created +
                ", data=" + data +
                '}';
    }
}
