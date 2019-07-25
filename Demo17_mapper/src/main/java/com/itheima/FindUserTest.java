package com.itheima;



import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FindUserTest {

    //根据id查找用户信息
    public User findUserById(int id);

    //根据name进行模糊查询
    public List<User> findUserByName(String name);

    //添加一条用户信息
    public void insertUser(User user);

    //修改一条用户信息
    public void updateUser(User user);

    //通过id删除一条用户信息
    public void deleteUserById(int id);

  //根据name和sex查询
    //如果name没传递，只根据sex查询；如果sex没传递，只根据name查询；如果name和sex都没传，全查询
    public List<User> findUserByNameAndSex(@Param("username") String name,@Param("sex") String sex);

    //在id范围内查找指定的用户
    //参数在指定id范围内查找指定用户
    public List<User> findUserByAllId(@Param("list")List<Integer> list);

    //-- 查询所有订单信息及订单下的用户信息
    public List<Order> queryOrderAndUser();
}
