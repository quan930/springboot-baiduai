package cn.lilq.baiduai.pojo;

/**
 * 提交表单
 */
public class PostMess {
    private String image;//图片 token/base64
    private String name;//用户名称
    private String imageType;//图片类别


    public PostMess() {
    }

    public PostMess(String image, String name, String imageType) {
        this.image = image;
        this.name = name;
        this.imageType = imageType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @Override
    public String toString() {
        return "PostMess{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", imageType='" + imageType + '\'' +
                '}';
    }
}
