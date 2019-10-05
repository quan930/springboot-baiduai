package cn.lilq.baiduai.dao;

import cn.lilq.baiduai.pojo.User;

import java.util.List;

public interface AIDAO {
    /**
     * 分组映射 根据name 生成分组 id(唯一)
     * @param user 包含用户name
     * @return
     */
    User insertUser(User user);

    /**
     * 查询映射 根据id查询用户信息
     * @param user 包含用于user
     * @return 返回用于信息
     */
    User getUser(User user);

    /**
     * 获取当前全部用户映射
     * @return
     */
    List<User> getUsers();

    /**
     * 增加用户映射
     * @return
     */
    boolean addUser(List<User> users);

    /**
     * 删除制订用户
     * @param user
     */
    void removeUser(User user);

    /**
     * 获取当前分组
     * @return 分组规则 组1,组2,......
     */
    String getGroup();
}
