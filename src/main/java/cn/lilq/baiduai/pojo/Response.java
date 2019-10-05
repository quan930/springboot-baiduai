package cn.lilq.baiduai.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    private String errorMsg;
    private Result result;

    public Response() {
    }

    public Response(String errorMsg, Result result) {
        this.errorMsg = errorMsg;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "errorMsg='" + errorMsg + '\'' +
                ", result=" + result +
                '}';
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result{
        private List<cn.lilq.baiduai.pojo.User> users;
        private Integer num;//人脸数量
        private List<Face> faceList;//人脸列表

        public Result() {
        }

        public Result(List<cn.lilq.baiduai.pojo.User> users, Integer num, List<Face> faceList) {
            this.users = users;
            this.num = num;
            this.faceList = faceList;
        }

        public List<cn.lilq.baiduai.pojo.User> getUsers() {
            return users;
        }

        public void setUsers(List<cn.lilq.baiduai.pojo.User> users) {
            this.users = users;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public List<Face> getFaceList() {
            return faceList;
        }

        public void setFaceList(List<Face> faceList) {
            this.faceList = faceList;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "users=" + users +
                    ", num=" + num +
                    ", faceList=" + faceList +
                    '}';
        }
    }
    //人脸对象
    public static class Face{
        private Location location;//位置
        private User user;


        public Face() {
        }

        public Face(Location location, User user) {
            this.location = location;
            this.user = user;
        }

        @Override
        public String toString() {
            return "Face{" +
                    "location=" + location +
                    ", user=" + user +
                    '}';
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
    public static class User{
        private String name;
        private Double score;//相识程度

        public User(String name, Double score) {
            this.name = name;
            this.score = score;
        }

        public User() {
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }
    }

    public static class Location{
        private Double left;//人脸区域离左边界的距离
        private Double top;//人脸区域离上边界的距离
        private Double width;//人脸区域的宽度
        private Double height;//人脸区域的高度
        private Integer rotation;//旋转角度

        public Location(Double left, Double top, Double width, Double height, Integer rotation) {
            this.left = left;
            this.top = top;
            this.width = width;
            this.height = height;
            this.rotation = rotation;
        }

        public Location() {
        }

        public Double getLeft() {
            return left;
        }

        public void setLeft(Double left) {
            this.left = left;
        }

        public Double getTop() {
            return top;
        }

        public void setTop(Double top) {
            this.top = top;
        }

        public Double getWidth() {
            return width;
        }

        public void setWidth(Double width) {
            this.width = width;
        }

        public Double getHeight() {
            return height;
        }

        public void setHeight(Double height) {
            this.height = height;
        }

        public Integer getRotation() {
            return rotation;
        }

        public void setRotation(Integer rotation) {
            this.rotation = rotation;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "left=" + left +
                    ", top=" + top +
                    ", width=" + width +
                    ", height=" + height +
                    ", rotation=" + rotation +
                    '}';
        }
    }
}
