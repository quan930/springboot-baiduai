package cn.lilq.baiduai.controller;

import cn.lilq.baiduai.api.Client;
import cn.lilq.baiduai.dao.AIDAO;
import cn.lilq.baiduai.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AICon {
    @Autowired
    private AIDAO aidao;
    @Autowired
    private Client client;
    public AICon() {
    }
    //注册用户映射，人脸
    @RequestMapping(value = "/baiduai/v1/faceset/face",method = RequestMethod.POST)
    public Response faceAdd(@RequestBody PostMess postMess){
        User user = aidao.insertUser(new User(null,null,postMess.getName()));
        FaceAddAPI faceAddAPI = client.add(postMess.getImage(),postMess.getImageType(),user.getGroupId(),user.getId());
        if (!faceAddAPI.getErrorMsg().equals("SUCCESS"))
            aidao.removeUser(user);
        return new Response(faceAddAPI.getErrorMsg(),null);
    }

    //获得全部用户映射
    @RequestMapping(value = "/baiduai/v1/faceset/users",method = RequestMethod.GET)
    public Response users(){
        return new Response("SUCCESS",new Response.Result(aidao.getUsers(),null,null));
    }

    //增加用户映射
    @RequestMapping(value = "/baiduai/v1/faceset/users",method = RequestMethod.POST)
    public Response users(@RequestBody List<User> users){
        if (aidao.addUser(users))
            return new Response("SUCCESS",null);
        return new Response("add user mapping error",null);
    }

    //人脸搜索 m-n
    @RequestMapping(value = "/baiduai/v1/face/multi-search",method = RequestMethod.POST)
    public Response faceSearch(@RequestBody PostMess postMess){
//        try {
//            imgParam = URLEncoder.encode(base64, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        FaceSearchAPI faceSearchAPI = client.search(postMess.getImage(),postMess.getImageType(),aidao.getGroup());
        Response response = new Response();
        Response.Result resultNew = new Response.Result();
        if (faceSearchAPI.getResult()!=null){
            FaceSearchAPI.Result result = faceSearchAPI.getResult();
            //获取并设置人脸数量
            resultNew.setNum(result.getNum());
            //响应人脸列表
            List<Response.Face> facesNew = new ArrayList<>();
            //获取人脸列表
            List<FaceSearchAPI.Face> faces = result.getFaceList();
            faces.forEach(face -> {
                //响应报文对象
                Response.Face faceNew = new Response.Face();
                //获取人脸位置
                FaceSearchAPI.Location location = face.getLocation();
                //添加人脸位置
                faceNew.setLocation(new Response.Location(location.getLeft(),location.getTop(),location.getWidth(),location.getHeight(),location.getRotation()));
                //获取概率最大用户
                FaceSearchAPI.User user = face.getUserList().stream().max((o1, o2) -> o1.getScore()>=o2.getScore()?1:-1).get();
//                System.out.println("用户概率最大"+user);
                User user1 = aidao.getUser(new User(null,user.getId(),null));
//                System.out.println("用户===="+user1);
                //人脸对应用户
                faceNew.setUser(new Response.User(user1.getName(),user.getScore()));
                //添加用户
                facesNew.add(faceNew);
            });
            resultNew.setFaceList(facesNew);
            response.setResult(resultNew);
        }
        response.setErrorMsg(faceSearchAPI.getErrorMsg());
        return response;
    }
}
