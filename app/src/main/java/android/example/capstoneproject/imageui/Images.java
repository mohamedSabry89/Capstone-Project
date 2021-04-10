package android.example.capstoneproject.imageui;

public class Images {

    String url;
    String code;

    public Images(String url, String code) {
        this.url = url;
        this.code = code;
    }

    public Images() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
